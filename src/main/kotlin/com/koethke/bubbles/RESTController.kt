package com.koethke.bubbles

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RESTController {

    @GetMapping("/")
    fun echo(@RequestParam( name="msg", required = false, defaultValue = "Nothing") msg: String,
             model: Model): String {
        return msg
    }


}