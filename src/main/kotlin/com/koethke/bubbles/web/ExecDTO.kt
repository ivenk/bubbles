package com.koethke.bubbles.web

data class ExecDTO(val name: String, val inputs: List<ValueDTO>, val outputs: List<ValueDTO>, val code: String)