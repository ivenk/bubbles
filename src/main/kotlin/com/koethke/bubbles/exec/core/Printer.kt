package com.koethke.bubbles.exec.core

import com.koethke.bubbles.core.IFunction
import com.koethke.bubbles.core.IData

class Printer: IFunction {
    override fun run(input: IData): IData {
        val msg = input.getData() ["Message"]
        println(msg)

        return object : IData {
            override fun getData(): Map<String, String> {
                return mapOf()
            }
        }
    }
}