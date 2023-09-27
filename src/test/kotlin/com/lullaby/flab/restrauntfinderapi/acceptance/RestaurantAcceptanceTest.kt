package com.lullaby.flab.restrauntfinderapi.acceptance

import com.lullaby.flab.restrauntfinderapi.acceptance.fixture.로그인
import com.lullaby.flab.restrauntfinderapi.acceptance.fixture.식당_생성
import com.lullaby.flab.restrauntfinderapi.acceptance.fixture.회원_가입
import com.lullaby.flab.restrauntfinderapi.application.restaurant.response.RestaurantResponse
import com.lullaby.flab.restrauntfinderapi.domain.FoodType
import io.restassured.RestAssured
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class RestaurantAcceptanceTest : AcceptanceTest() {

    var accessToken: String? = null

    @BeforeEach
    fun beforeEach() {
        회원_가입("user", "1234")
        accessToken = 로그인("user", "1234")
    }

    @DisplayName("식당을 생성 한다.")
    @Test
    fun create() {
        val restaurantResponse = 식당_생성(accessToken!!, "강남교자 본점", "서울 서초구 강남대로69길 11 삼미빌딩", 20, FoodType.KOREAN)
        assertThat(restaurantResponse.id).isNotNull
    }

    @Test
    fun lists() {
        식당_생성(accessToken!!, "강남교자 본점", "서울 서초구 강남대로69길 11 삼미빌딩", 20, FoodType.KOREAN)
        식당_생성(accessToken!!, "쉐이크쉑 강남대로점", "서울 서초구 강남대로 421", 30, FoodType.WESTERN)

        val response = RestAssured
            .given().log().all()
            .header("Authorization", "Bearer $accessToken")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .`when`().get("/restaurants")
            .then().log().all().extract()

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())

        val restaurantResponses = response.jsonPath().getList("", RestaurantResponse::class.java)
        assertThat(restaurantResponses.size).isEqualTo(2)
    }

}
