package com.koethke.bubbles.core

import com.koethke.bubbles.exec.core.Printer
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProgramTest {

    @Test
    fun simpleProgram() {
        val mockBubble = object : IFunction {
            override val id: String
                get() = "sthUnique"

            override fun run(input: TransferData): TransferData {
                return TransferData()
            }

            override fun inputs(): Array<String> {
                return emptyArray()
            }
        }

        val value = object : Program(Unit(mockBubble), emptyArray()) {}
        value.run()
    }

    @Test
    fun singlePrinter() {
        val node = Unit(TestPrinter("id"), emptyList())

        object : Program(node, emptyArray()){}.apply { this.run() }
    }

    @Test
    fun twoPrinters() {
        val node = Unit(TestPrinter("id"), listOf(Unit(TestPrinter("id2"), emptyList())))

        object: Program(node, emptyArray()){}.apply { this.run() }
    }


    /// Helpers

    /**
     * Very simple IFunction implementation. Prints its own id.
     */
    class TestPrinter(override val id: String) : IFunction {
        override fun run(input: TransferData): TransferData {
            println(id)
            return TransferData()
        }

        override fun inputs(): Array<String> {
            return emptyArray()
        }
    }
}