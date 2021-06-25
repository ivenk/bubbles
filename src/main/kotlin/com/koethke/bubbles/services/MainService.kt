package com.koethke.bubbles.services

import org.springframework.stereotype.Service

@Service
class MainService {

    fun getKnownExecutables() : List<String> {
        return listOf("Printer", "Getter", "Addition")
    }
}