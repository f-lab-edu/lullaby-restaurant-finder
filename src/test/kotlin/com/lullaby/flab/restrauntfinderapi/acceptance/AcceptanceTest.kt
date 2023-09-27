package com.lullaby.flab.restrauntfinderapi.acceptance

import com.lullaby.flab.restrauntfinderapi.domain.MemberRepository
import com.lullaby.flab.restrauntfinderapi.domain.RestaurantRepository
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcceptanceTest {
    @LocalServerPort
    lateinit var serverPort: Integer

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var restaurantRepository: RestaurantRepository

    @BeforeEach
    fun setUp() {
        RestAssured.port = serverPort.toInt()
        memberRepository.deleteAll()
        restaurantRepository.deleteAll()
    }
}
