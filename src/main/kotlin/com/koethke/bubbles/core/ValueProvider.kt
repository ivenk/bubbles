package com.koethke.bubbles.core

interface ValueProvider<T> : IFunction {
    val value : T
}