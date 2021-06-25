package com.koethke.bubbles.exec.core

import com.koethke.bubbles.core.IExecID
import com.koethke.bubbles.core.IFunction
import com.koethke.bubbles.core.TransferData

class Addition: IFunction, IExecID {
    override val execID: String = "2"

    override fun run(input: TransferData): TransferData {
        val first = input.data["First"]
        val second = input.data["Second"]

        val sum = first!!.toInt() + second!!.toInt()

        return TransferData().apply { this.data.plusAssign(Pair("Sum", sum.toString())) }
    }

    override fun inputs(): Array<String> {
        return arrayOf("First", "Second")
    }


}