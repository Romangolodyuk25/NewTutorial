package com.example.NewTutorial.Service

import com.example.NewTutorial.dto.HelloDto
import org.springframework.stereotype.Service

@Service
class HelloService {
    var nameBd = HashMap<String, String>()
    var randomGreetings = HashMap<String, MutableList<String>>()
    fun getHello(): String {
        return "Hello Service"
    }
    fun getHelloRomchik(): String {
        return "Hello Romchik"
    }

    fun getHelloForName(name: String):String{
        return nameBd.get(name)!!
    }
    fun addName(name: String, greetings: String){
        nameBd.put(name, greetings)
    }

    fun allName(): Map<String, String> {
        return nameBd
    }

    fun delete(name: String){
        nameBd.remove(name)
    }

    /**
     * Методы для Рандомных Приветствий из Списка
     */
    fun addRandomGreetings(name: String, greetings: MutableList<String>){
        randomGreetings.put(name, greetings)
//        var list = mutableListOf("Hello", "Good Morning", "Good Evening", "Хай", "Чо Каво")
//      var values = (0 until list.size)
//        var random = values.random()
//        return ("$name ${list[random]}") .
    }

    fun getRandomGreetings(name: String): String {
        var list = randomGreetings.getValue(name)
        var values = (0 until list.size)
        var random = values.random()
        var str = randomGreetings.get(name)
        return ("$name ${str!![random]}")
    }
}