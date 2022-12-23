package com.example.NewTutorial.Service

import com.example.NewTutorial.Exception.NullKeyException
import com.example.NewTutorial.dto.HelloDto
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class HelloService {
    var name2Greetings = HashMap<String, MutableList<String>>()

    fun allName(): Map<String, MutableList<String>> {
        return name2Greetings
    }

    fun getHelloForName(name: String): String {
        return name2Greetings.get(name).toString()
    }
    fun delete(name: String){
        name2Greetings.remove(name)
    }

    fun deleteGreeting(name: String, index: Int):MutableList<String>?{
        val nameAndGreeting = name2Greetings.getValue(name)
        nameAndGreeting.removeAt(index)
        return name2Greetings.get(name)
    }


    fun addName2Greetings(name: String, greetings: MutableList<String>){
        name2Greetings.put(name, greetings)
    }

    fun getRandomGreeting(name: String): String {
        if (name2Greetings.contains(name) == false) {
            return "$name key is empty"
            throw NullKeyException("Key name is empty")
        } else {
            val greetings = name2Greetings.getValue(name)
            var values = (0 until greetings.size)
            var random = values.random()
            var str = name2Greetings.get(name)
            return ("$name ${str?.get(random)}") //str[random]
        }
    }
}