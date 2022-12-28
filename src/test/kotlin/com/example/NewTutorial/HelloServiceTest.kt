package com.example.NewTutorial

import com.example.NewTutorial.Service.HelloService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class HelloServiceTest {

    @Autowired
    private lateinit var mvc: MockMvc
    @Autowired
    private lateinit var helloService: HelloService

    @BeforeEach
    fun cleanUp() {
        helloService.deleteAll()
    }

    @Test
    fun `should return all names with greetings`() {
        //Подготовка данных
        helloService.addName2Greetings("Roman", mutableListOf("Хай", "Чо каво", "Вацааап"))
        //Тестирование
        mvc.get("/getAllNames").andExpect {
            status { isOk() }
            content {
                json("{\"Roman\":[\"Хай\",\"Чо каво\",\"Вацааап\"]}")
            }
        }
    }

}