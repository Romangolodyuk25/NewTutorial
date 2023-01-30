package com.example.NewTutorial.Controller

import com.example.NewTutorial.Service.HelloService
import com.example.NewTutorial.dto.Greeting
import com.example.NewTutorial.dto.HelloDto
import org.springframework.web.bind.annotation.*

@RestController
class HelloController(var helloService: HelloService,
) {

    @GetMapping("/getAllNames")
    fun getAllNames(): HelloDto {
        return helloService.getAllNamesAndGreetings()
    }

    @GetMapping("/helloForName")
    fun getNameGreetings(@RequestParam name: String): Greeting?{
        return helloService.getHelloForName(name)
    }
    @PostMapping("/addNameAndGreetings")
    fun addNameAndGreetings(@RequestParam name: String, @RequestBody greeting: Greeting): Greeting?{
        return helloService.addName2Greetings(name, greeting)
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