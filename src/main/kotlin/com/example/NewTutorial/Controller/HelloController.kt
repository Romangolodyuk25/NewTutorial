package com.example.NewTutorial.Controller

import com.example.NewTutorial.Service.HelloService
import com.example.NewTutorial.dto.HelloDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(var helloService: HelloService) {

    @GetMapping("/hello")
    fun hello(): String{
        return helloService.getHelloRomchik()
    }

    @GetMapping("/hello-service")
    fun helloKotlin(): String {
        return helloService.getHello()
    }

    @GetMapping("/hello-dto")
    fun helloDto(): HelloDto {
        return HelloDto("Hello from the DTO")// не работает
    }

    @GetMapping("/helloName")
    fun helloForName(@RequestParam yourName: String):String {
        return helloService.getHelloForName(yourName)
    }
}