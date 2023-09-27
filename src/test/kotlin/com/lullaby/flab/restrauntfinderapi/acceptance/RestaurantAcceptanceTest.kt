package com.lullaby.flab.restrauntfinderapi.acceptance

import com.lullaby.flab.restrauntfinderapi.acceptance.fixture.로그인
import com.lullaby.flab.restrauntfinderapi.acceptance.fixture.회원_가입
import com.lullaby.flab.restrauntfinderapi.application.auth.request.SignInRequest
import com.lullaby.flab.restrauntfinderapi.application.auth.request.SignUpRequest
import io.restassured.RestAssured
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class RestaurantAcceptanceTest: AcceptanceTest() {

    var accessToken: String? = null

    @BeforeEach
    fun beforeEach() {
        회원_가입("user", "1234")
        accessToken = 로그인("user", "1234")
    }

    @DisplayName("식당을 생성 한다.")
   @Test
    fun create() {
        val body = mapOf<String, String>()
        val response = RestAssured
            .given().log().all()
            .header("Authorization", "Bearer $accessToken")
            .body(body)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .`when`().post("/restaurant")
            .then().log().all().extract()

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())
    }
}
