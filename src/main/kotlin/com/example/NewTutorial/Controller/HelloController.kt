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

    @GetMapping("/getAllName")
    fun getAllNames(): Map<String, MutableList<String>>{
        return helloService.getAllNamesAndGreetings()
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
    fun deleteName(@RequestParam name: String) {
        return helloService.delete(name)
    }

    @DeleteMapping("/deleteGreeting")
    fun deleteGreeting(@RequestParam name: String, @RequestParam greeting: String){
        helloService.deleteGreeting(name, greeting)//изменить что бы удаляось по значение а не по индексу
    }


    @GetMapping("/getRandomGreeting")
    fun getRandomGreeting(@RequestParam name: String): String {
        return helloService.getRandomGreeting(name)
    }

}