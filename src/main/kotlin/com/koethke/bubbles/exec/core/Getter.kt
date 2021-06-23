package com.koethke.bubbles.exec.core

import com.koethke.bubbles.core.IFunction
import com.koethke.bubbles.core.TransferData

class Getter(override val id: String) : IFunction {
    override fun run(input: TransferData): TransferData {
        return TransferData().apply { this.data.plus(Pair("Value", input.data["__input"].orEmpty())) }
    }

    override fun inputs(): Array<String> {
        return emptyArray()
    }
}