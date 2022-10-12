package com.example.controller

import com.example.bean.ColorPicker
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class HelloController {

    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        return "hello world!!!"
    }

}

@Controller("/test")
class TestController(val colorPicker: ColorPicker) {
    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        return colorPicker.color()
    }
}