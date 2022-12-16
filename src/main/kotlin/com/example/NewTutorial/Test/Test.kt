package com.example.NewTutorial

import com.example.NewTutorial.dto.HelloDto
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(KotlinDemoApplication::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class KotlinDemoApplicationTests {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun whenCalled_shouldReturnHelloService() {
        var result = testRestTemplate
//            .getForEntity("/hello-service", String::class.java)
//
//        assertNotNull(result)
//        assertEquals(result?.statusCode, HttpStatus.OK)
//        assertEquals(result?.body, "hello service")

            .getForEntity("/hello-dto", HelloDto::class.java)

        assertNotNull(result)
        assertEquals(result?.statusCode, HttpStatus.OK)
        assertEquals(result?.body, HelloDto("Hello from the dto"))
    }
}
