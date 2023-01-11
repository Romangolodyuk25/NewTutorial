package com.example.NewTutorial

import com.example.NewTutorial.Service.HelloService
import io.kotest.matchers.shouldBe
import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.util.ResourceUtils
import java.nio.file.Files

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
    fun `should return all names with greeting`() {
        helloService.addName2Greetings("Roma", mutableListOf("Хай", "Как дела", "Че каво"))
        val expectedResponse = getFileContent("get_all_names_with_greetings.json")
        mvc.get("/getAllNames").andExpect {
            status { isOk() }
            content { json(expectedResponse) }
        }
    }

    @Test
    fun `should return greetings for name`() {
        helloService.addName2Greetings("Romchik", mutableListOf("Как дела", "Чем занят", "Какие планы"))
        val expectedResponse = getFileContent("hello_for_name.json");
        val name = "Romchik"
        mvc.get("/helloForName?name=$name").andExpect {
            status { isOk() }
            content { json(expectedResponse) }
        }
    }

    @Test
    fun `should add name and greetings in map`() {
        val request = getFileContent("add_name_and_greetings_request.json")
        val expectedResponse = getFileContent("add_name_and_greetings_response.json")
        mvc.post("/addNameAndGreetings"){
            content = request
            contentType = APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { json(expectedResponse) }
        }
        helloService.getAllNamesAndGreetings().size shouldBe 1
    }

    @Test
    fun `should delete name and greetigs from map`() {
        helloService.addName2Greetings("Roma", mutableListOf("Привет", "Как дела", "Как сам"))
        val name = "Roma"
        mvc.delete("/deleteName?name=$name").andExpect {
            status { isOk() }
        }
        helloService.getAllNamesAndGreetings().size shouldBe 0
    }

    @Test
    fun `should delete greeting by value`() {
        helloService.addName2Greetings("Roma", mutableListOf("Привет", "Хай", "Как дела"))
        val name = "Roma"
        val value = "Как дела"
        mvc.delete("/deleteGreeting?name=$name&greeting=$value").andExpect {
            status { isOk() }
        }
        mvc.get("/getAllNames").andExpect {
            status { isOk() }
            content {
                json("{\"Roma\":[\"Привет\",\"Хай\"]}")
            }
        }
    }

    @Test
    fun `should return random greeting from list greetings`() {
        helloService.addName2Greetings("Roma", mutableListOf("Привет", "Хай", "Как дела"))
        val name = "Roma"
        mvc.get("/getRandomGreeting?name=$name").andExpect {
            status { isOk() }
            content {
                string(anyOf(`is`("$name Привет"), `is`("$name Хай"), `is`("$name Как дела")))
            }
        }
    }

    private fun getFileContent(fileName: String): String {
        return Files.readString(ResourceUtils.getFile("classpath:stubs/$fileName").toPath())
    }
}