package com.example.NewTutorial.Service

import com.example.NewTutorial.Exception.NullKeyException
import com.example.NewTutorial.dto.HelloDto
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class HelloService {
    var name2Greetings = HashMap<String, MutableList<String>>()

    fun getAllNamesAndGreetings(): Map<String, MutableList<String>> {
        return name2Greetings
    }

    fun getHelloForName(name: String): String {
        return name2Greetings.get(name).toString()
    }
    fun delete(name: String){
        name2Greetings.remove(name)
    }

    fun deleteGreeting(name: String, greeting: String){
        val values = greeting
        val mapGreeting = name2Greetings.getValue(name)
        for (i in 0 until mapGreeting.size){
            if(values == mapGreeting[i]){
                var index = i
                name2Greetings.getValue(name).removeAt(index)
            }
        }
      //изменить что бы удаляось по значение а не по индексу, Проверить
    }


    fun addName2Greetings(name: String, greetings: MutableList<String>){
        name2Greetings.put(name, greetings)
    }

    fun getRandomGreeting(name: String): String {
        if (name2Greetings.contains(name) == false) {
            return "$name key is empty"
        } else {
            val greetings = name2Greetings.getValue(name)
            var values = (0 until greetings.size)
            var random = values.random()
            var str = name2Greetings.get(name)
            return ("$name ${str?.get(random)}") //str[random]
        }
    }
}