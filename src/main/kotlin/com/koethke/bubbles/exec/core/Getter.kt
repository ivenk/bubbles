package com.koethke.bubbles.exec.core

import com.koethke.bubbles.core.IFunction
import com.koethke.bubbles.core.TransferData
import com.koethke.bubbles.core.ValueProvider

class Getter(private val value: String) : ValueProvider {
    override fun run(input: TransferData): TransferData {
      //  return TransferData().apply { this.data.plusAssign(Pair("Value", input.data["__input"].orEmpty())) }
        return TransferData().apply { this.data.plusAssign(Pair("Value", value)) }
    }

    override fun inputs(): Array<String> {
        return emptyArray()
    }
}