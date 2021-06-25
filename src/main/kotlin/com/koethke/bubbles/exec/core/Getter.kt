package com.koethke.bubbles.exec.core

import com.koethke.bubbles.core.IExecID
import com.koethke.bubbles.core.TransferData
import com.koethke.bubbles.core.ValueProvider

class Getter(override val value: String) : ValueProvider<String>, IExecID {
    override val execID: String = "1"

    override fun run(input: TransferData): TransferData {
      //  return TransferData().apply { this.data.plusAssign(Pair("Value", input.data["__input"].orEmpty())) }
        return TransferData().apply { this.data.plusAssign(Pair("Value", value)) }
    }

    override fun inputs(): Array<String> {
        return emptyArray()
    }
}