package com.example.NewTutorial.Service

import com.example.NewTutorial.dto.HelloDto
import org.springframework.stereotype.Service

@Service
class HelloService {
    var nameBd = HashMap<String, String>()
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
}