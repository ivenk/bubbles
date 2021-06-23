package com.koethke.bubbles.core

/**
 * The program is ready for execution. The order of the nodes as well as the connections between them have already been determined as much as statically possible.
 * The program is immutable to external sources.
 */
abstract class Program(private val unit: Unit, private val connections: Array<Connection>)
//TODO: The structure of the connections needs to be either changed or made available within units without iteration over the list
{
    val dataStorage = mutableMapOf<String, String>()

    fun run() {
        TODO("Implement logic to execute the program")
    }

    private fun execute(unit: Unit) {
        val data = getData()
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

    private fun getData(): TransferData {
        return TransferData()
    }
}

//TODO: We define the connections before hand. How can we match the connections with the id that is latter generated for the unit ?
// How about the assembler ?

class Unit(private val executable: IFunction, val children : List<Unit> = mutableListOf()) : IExecute {
    //TODO: This needs a unique object id
    private val id = "test"

    fun addChild(child : Unit) {
        this.children.plus(child)
    }

    override fun execute(data: TransferData): TransferData {
        return executable.run(data).apply { this.data.plusAssign("__unitID" to id) }
    }
}

class SingleThreadProgram(unit: Unit, connections: Array<Connection>) : Program(unit, connections)






