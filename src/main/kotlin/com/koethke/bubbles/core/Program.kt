package com.koethke.bubbles.core

/**
 * The program is ready for execution. The order of the nodes as well as the connections between them have already been determined as much as statically possible.
 * The program is immutable to external sources.
 */
abstract class Program(private val unit: Unit, private val connections: Array<Connection>)
//TODO: The structure of the connections needs to be either changed or made available within units without iteration over the list
{
    val dataStorage = mapOf<String, String>()

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

    private fun storeData(data: IData) {
        dataStorage.plus(Pair("key", "value"))
    }

    private fun getData(): IData {
        return object : IData {
            override fun getData(): Map<String, String> {
                return mapOf()
            }
        }
    }
}

//TODO: We define the connections before hand. How can we match the connections with the id that is latter generated for the unit ?

class Unit(private val executable: IFunction, val children : List<Unit> = mutableListOf()) : IExecute {
    //TODO: This needs a unique object id
    val id = ""

    fun addChild(child : Unit) {
        this.children.plus(child)
    }

    override fun execute(data: IData): IData {
        return executable.run(data)
    }
}

class SingleThreadProgram(unit: Unit, connections: Array<Connection>) : Program(unit, connections)






