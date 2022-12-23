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

    @GetMapping("/hello-dto")
    fun helloDto(): HelloDto {
        return HelloDto("Hello from the DTO")
    }

    @GetMapping("/getAllName")
    fun getAllName(): Map<String, MutableList<String>>{
        return helloService.allName()
    }

    @GetMapping("/helloForName")
    fun getNameGreetings(@RequestParam name: String):String {
        return helloService.getHelloForName(name)
    }
    @PostMapping("/addNameAndGreetings")
    fun addNameAndGreetings(@RequestParam name: String, @RequestParam greetings: MutableList<String>){
        helloService.addName2Greetings(name, greetings)
    }

    @DeleteMapping("/deleteName")
    fun deletedName(@RequestParam name: String) {
        return helloService.delete(name)
    }

    @DeleteMapping("/deleteGreeting")
    fun deleteGreeting(name: String, index: Int): MutableList<String>?{
        return helloService.deleteGreeting(name, index)
    }


    @GetMapping("/getRandomGreeting")
    fun getRandomGreeting(@RequestParam name: String): String {
        return helloService.getRandomGreeting(name)
    }

}