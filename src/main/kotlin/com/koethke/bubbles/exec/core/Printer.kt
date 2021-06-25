package com.koethke.bubbles.exec.core

import com.koethke.bubbles.core.IFunction
import com.koethke.bubbles.core.TransferData

class Printer : IFunction {
    override fun run(input: TransferData): TransferData {
        val msg = input.data["Message"]
        println(msg)

        return TransferData()
    }

    override fun inputs(): Array<String> {
        return arrayOf("Message")
    }
}