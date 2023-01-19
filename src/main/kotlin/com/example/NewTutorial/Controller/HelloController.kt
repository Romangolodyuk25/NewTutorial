package com.example.NewTutorial.Controller

import com.example.NewTutorial.Service.HelloService
import com.example.NewTutorial.dto.HelloDto
import org.springframework.web.bind.annotation.*

@RestController
class HelloController(var helloService: HelloService,
) {

    @GetMapping("/getAllNames")
    fun getAllNames(): MutableCollection<HelloDto> {
        return helloService.getAllNamesAndGreetings()
    }

    @GetMapping("/helloForName")
    fun getNameGreetings(@RequestParam name: String): MutableList<String>? {
        return mutableListOf()//helloService.getHelloForName(name) поставил пока что бы работало
    }
    @PostMapping("/addNameAndGreetings")
    fun addNameAndGreetings(@RequestParam name: String, @RequestBody helloDto: HelloDto){
        helloService.addName2Greetings(name, helloDto)
    }

    @DeleteMapping("/deleteName")
    fun deleteName(@RequestParam name: String) {
        return helloService.delete(name)
    }

//    @DeleteMapping("/deleteGreeting")
//    fun deleteGreeting(@RequestParam name: String, @RequestParam greeting: String){
//        helloService.deleteGreeting(name, greeting)
//    }


//    @GetMapping("/getRandomGreeting")
//    fun getRandomGreeting(@RequestParam name: String): String {
//        return helloService.getRandomGreeting(name)
//    }

}