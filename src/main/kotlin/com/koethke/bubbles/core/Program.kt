package com.koethke.bubbles.core

/**
 * The program is ready for execution. The order of the nodes as well as the connections between them have already been determined as much as statically possible.
 * The program is immutable to external sources.
 */
class Program(private val units: Array<Unit>, private val connections: Array<Connection>,var args : IData = object : IData {
    override fun getData(): Map<String, String> {
        return mapOf()
    } })
{
    fun run() {
        TODO("Implement logic to execute the program")
    }


    private fun execute(unit: Unit, data: IData) {
        val result = unit.execute(data)

        // Default root: Max one child
        if (unit.children.isNotEmpty()) {
            val child = unit.children.first()

            val value = object : IData {
                override fun getData(): Map<String, String> {
                    return mapOf("Message" to "New Message")
                }
            }
            execute(child, value)
        }
    }
}

class Unit(private val bubble: IFunction, val children : List<Unit> = mutableListOf()) : IExecute {
    fun addChild(child : Unit) {
        this.children.plus(child)
    }


    override fun execute(data: IData): IData {
        return bubble.run(data)
    }
}






