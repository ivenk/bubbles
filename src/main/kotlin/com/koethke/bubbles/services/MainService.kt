package com.koethke.bubbles.services

import com.koethke.bubbles.core.Assembler
import com.koethke.bubbles.core.Blueprint
import org.springframework.stereotype.Service

@Service
class MainService {
    fun getKnownExecutables() : List<String> {
        return listOf("Printer", "Getter", "Addition")
    }

    fun compileBlueprint(blueprint: Blueprint) : Boolean {
        Assembler().create(blueprint)
        return true
    }

}