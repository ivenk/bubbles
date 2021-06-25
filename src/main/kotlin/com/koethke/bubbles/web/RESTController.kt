package com.koethke.bubbles.web

import com.koethke.bubbles.core.Blueprint
import com.koethke.bubbles.services.MainService
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RESTController {

    @Autowired
    lateinit var mainService: MainService

    @GetMapping("/echo")
    fun echo(@RequestParam( name="msg", required = false, defaultValue = "Something") msg: String,
             model: Model): String {
        return msg
    }

    @GetMapping("/")
    fun main(model: Model) :String {
        return "main"
    }

    @GetMapping("/services", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun services(model: Model): ResponseEntity<List<ExecDTO>> {
        return ResponseEntity<List<ExecDTO>>(mainService.getKnownExecutables().map {
            ExecDTO(
                it,
                emptyList(),
                emptyList(),
                "Something sickkk",
                "1"
            )
        }, HttpStatus.OK)
    }


    @PostMapping()
    fun compile(): ResponseEntity<Boolean> {
        // TODO Takes in a description of the created program in the frontend. Code components are identified via id.
        val compileBlueprint = mainService.compileBlueprint(Blueprint(emptyArray(), emptyArray()))
        return ResponseEntity<Boolean>(true, HttpStatus.OK)
    }
}