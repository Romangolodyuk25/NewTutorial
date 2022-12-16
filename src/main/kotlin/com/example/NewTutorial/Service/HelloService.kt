package com.example.NewTutorial.Service

import com.example.NewTutorial.dto.HelloDto
import org.springframework.stereotype.Service

@Service
class HelloService {
    fun getHello(): String {
        return "Hello Service"
    }
    fun getHelloRomchik(): String {
        return "Hello Romchik"
    }

    fun getHelloForName(name: String): String{
        var response = ""
        if (name == "Romchik") {
            response = "Hello Romchik"
        } else if (name == "Leha") {
            response = "Darova Leha"
        } else {
            response = "$name is not found"
        }
        return response
    }
}