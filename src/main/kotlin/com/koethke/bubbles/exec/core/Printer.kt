package com.koethke.bubbles.exec.core

import com.koethke.bubbles.core.IExecID
import com.koethke.bubbles.core.IFunction
import com.koethke.bubbles.core.TransferData

class Printer : IFunction, IExecID {
    override val execID: String = "0"

    override fun run(input: TransferData): TransferData {
        val msg = input.data["Message"]
        println(msg)

        return TransferData()
    }

    override fun inputs(): Array<String> {
        return arrayOf("Message")
    }
}