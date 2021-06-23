package com.koethke.bubbles.core

interface IFunction {

    val id : Int

    fun run(input: IData) : IData
}