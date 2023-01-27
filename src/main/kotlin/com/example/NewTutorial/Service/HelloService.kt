package com.example.NewTutorial.Service

import com.example.NewTutorial.dto.Greeting
import com.example.NewTutorial.dto.HelloDto
import org.springframework.stereotype.Service

@Service
class HelloService() {
    private var name2Greetings = HashMap<String, Greeting>()

    fun getAllNamesAndGreetings(): HelloDto {
        return HelloDto(name2Greetings.values.toList())
    }

    fun getHelloForName(name: String): HelloDto? {//вместо принмаемого отдельного параметра думаю положить data  объект
        TODO()
    }

    fun delete(name: String){
        name2Greetings.remove(name)
    }

//    fun deleteGreeting(name: String, greeting: String){
//        val values = greeting
//        val mapGreeting = name2Greetings.getValue(name)
//        for (i in 0 until mapGreeting.size){
//            if(values == mapGreeting[i]){
//                var index = i
//                name2Greetings.getValue(name).removeAt(index)
//            }
//        }
//      //изменить что бы удаляось по значение а не по индексу, Проверить
//    }


    fun addName2Greetings(name: String, greeting: Greeting){
        name2Greetings.put(name, greeting)
    }

//    fun getRandomGreeting(name: String): String {
//        if (name2Greetings.contains(name) == false) {
//            return "$name key is empty"
//        } else {
//            val greetings = name2Greetings.getValue(name)
//            var values = (0 until greetings.size)
//            var random = values.random()
//            var str = name2Greetings.get(name)
//            return ("$name ${str?.get(random)}") //str[random]
//        }
//    }

    fun deleteAll() {
        name2Greetings.clear()
    }
}