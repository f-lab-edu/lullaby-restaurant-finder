package com.lullaby.flab.restrauntfinderapi.acceptance

import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcceptanceTest {
    @LocalServerPort
    lateinit var serverPort: Integer
    @BeforeEach
    fun setUp() {
        RestAssured.port = serverPort.toInt()
    }
}
