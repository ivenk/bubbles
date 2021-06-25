package com.koethke.bubbles.core

import com.koethke.bubbles.exec.core.Addition
import com.koethke.bubbles.exec.core.Getter
import com.koethke.bubbles.exec.core.Printer
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProgramTest {

    @Test
    fun simpleProgram() {
        val mockBubble = object : IFunction {
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
        val node = Unit(TestPrinter(), emptyList())

        object : Program(node, emptyArray()){}.run()
    }

    @Test
    fun twoPrinters() {
        val node = Unit(TestPrinter(), listOf(Unit(TestPrinter(), emptyList())))

        object: Program(node, emptyArray()){}.run()
    }

    /*
    @Test
    fun testSingleGetter() {
        val node = Unit(Getter(), emptyList())
        val value = "toGet"

        val result = node.execute(TransferData().apply { this.data.plusAssign(Pair("__input", value)) })
        assert(value == result.data["Value"])
    }
*/
    @Test
    fun testPrinterAndGetter() {
        val printer = Unit(Printer())
        val value = "startValue"
        val node = Unit(Getter(value), listOf(printer))

        object: Program(node, arrayOf(Connection(node.id, printer.id, "Value", "Message"))) {}.run()
    }


    @Test
    fun testAddition() {
        val printer1 = Unit(Printer())

        val addition = Unit(Addition(), listOf(printer1))
        val getter2 = Unit(Getter("1"), listOf(addition))
        val getter1 = Unit(Getter("2"), listOf(getter2))

        val connections = arrayOf(
            Connection(getter2.id, addition.id, "Value", "First"),
            Connection(getter1.id, addition.id, "Value", "Second"),
            Connection(addition.id, printer1.id, "Sum", "Message")
        )

        object: Program(getter1, connections) {}.run()
    }



    /// Helpers

    /**
     * Very simple IFunction implementation. Prints its own id.
     */
    class TestPrinter() : IFunction {
        override fun run(input: TransferData): TransferData {
            println("bump")
            return TransferData()
        }

        override fun inputs(): Array<String> {
            return emptyArray()
        }
    }

    class TestAppender() : IFunction {
        override fun run(input: TransferData): TransferData {
            var n = input.data["Number"]!!
            n += "!"
            return TransferData().apply { this.data["Number"] = n }
        }

        override fun inputs(): Array<String> {
            return arrayOf("Number")
        }
    }
}