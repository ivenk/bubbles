package com.koethke.bubbles.core

interface IFunction {

    fun run(input: TransferData) : TransferData

    fun inputs(): Array<String>
}