package com.koethke.bubbles.core

/**
 * The program is ready for execution. The order of the nodes as well as the connections between them have already been determined as much as statically possible.
 * The program is immutable to external sources.
 */
abstract class Program(private val unit: Unit, private val connections: Array<Connection>)
//TODO: The structure of the connections needs to be either changed or made available within units without iteration over the list
{
    private val dataStorage = mutableMapOf<String, String>()

    fun run() {
        execute(unit)
    }

    private fun execute(unit: Unit) {
        val data = getData(unit)
        val result = unit.execute(data)
        storeData(result)

        // Default root: Max one child
        if (unit.children.isNotEmpty()) {
            val child = unit.children.first()
            execute(child)
        }
    }

    /**
     * Stores all values from TransferData in the global storage
      */
    private fun storeData(data: TransferData) {
        for (key in data.data.keys) {
            dataStorage.plus(Pair(data.data["__unitID@$key"], data.data[key]))
        }
    }

    /**
     * Retrieves the required data for the execution of a unit from global data storage
     */
    private fun getData(unit: Unit): TransferData {
        val data = TransferData()
        connections
            .filter { it.secondID == unit.id && it.secondValueID.equals(unit.executable.inputs()) }
            .forEach { data.data.plusAssign(Pair(it.secondValueID, dataStorage.getValue("" + it.firstID + "@" + it.firstValueID))) }

        return data
    }
}

//TODO: We define the connections before hand. How can we match the connections with the id that is latter generated for the unit ?
// How about the assembler ?

class Unit(val executable: IFunction, val children : List<Unit> = mutableListOf()) : IExecute {
    //TODO: This needs a unique object id
    val id = "test"

    override fun execute(data: TransferData): TransferData {
        return executable.run(data).apply { this.data.plusAssign("__unitID" to id) }
    }
}

class SingleThreadProgram(unit: Unit, connections: Array<Connection>) : Program(unit, connections)






