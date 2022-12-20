package com.example.NewTutorial.Controller

import com.example.NewTutorial.Service.HelloService
import com.example.NewTutorial.dto.HelloDto
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
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
        return HelloDto("Hello from the DTO")
    }

    @GetMapping("/getAllName")
    fun getAllName(): Map<String, String>{
        return helloService.allName()
    }

    @GetMapping("/helloForName")
    fun getNameGreetings(@RequestParam name: String):String {
        return helloService.getHelloForName(name)
    }

    @PostMapping("/addName")
    fun addName(@RequestParam name:String, @RequestParam greetings: String) {
        helloService.addName(name = name, greetings = greetings)
    }

    @DeleteMapping("/deleteName")
    fun deletedName(@RequestParam name: String) {
        return helloService.delete(name)
    }

    /**
     * Методы для Рандомных Приветствий из Списка
     */
    @PostMapping("/addRandomName")
    fun addRandomName(@RequestParam name: String, @RequestParam greetings: MutableList<String>){
        helloService.addRandomGreetings(name, greetings)
    }

    @GetMapping("/randomGreetings")
    fun randomGreetings(@RequestParam name: String): String {
        return helloService.getRandomGreetings(name)
    }


}