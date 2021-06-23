package com.koethke.bubbles.core

interface IFunction {

    val id : String

    fun run(input: TransferData) : TransferData

    fun inputs(): Array<String>
}