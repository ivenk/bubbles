package com.koethke.bubbles.core

interface IFunction {

    val id : Int

    fun run(input: TransferData) : TransferData

    fun inputs(): Array<String>
}