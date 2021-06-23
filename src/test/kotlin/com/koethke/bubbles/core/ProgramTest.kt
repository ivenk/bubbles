package com.koethke.bubbles.core

import com.koethke.bubbles.exec.core.Printer
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProgramTest {

    @Test
    fun simpleProgram() {
        val mockBubble = object : IFunction {
            override fun run(input: IData): IData {
                return emptyData()
            }
        }

        Program(Unit(mockBubble)).run()
    }

    @Test
    fun printProgram() {
        val node = Unit(Printer(), listOf(Unit(Printer())))

        val data = data(mapOf("Message" to "Wow"))

        Program(node, data).run()
    }

    // Helpers
    private fun data (returnValue: Map<String, String>) : IData {
        return object : IData {
            override fun getData(): Map<String, String> {
                return mapOf("Message" to "Wow!")
            }
        }
    }

    fun emptyData(): IData {
        return object : IData {
            override fun getData(): Map<String, String> {
                return mapOf()
            }
        }
    }
}