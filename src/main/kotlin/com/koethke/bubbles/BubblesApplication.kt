package com.koethke.bubbles

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class BubblesApplication

fun main(args: Array<String>) {
	runApplication<BubblesApplication>(*args)
}


