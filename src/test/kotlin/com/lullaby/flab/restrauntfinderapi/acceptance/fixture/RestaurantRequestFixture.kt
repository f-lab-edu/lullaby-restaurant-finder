package com.lullaby.flab.restrauntfinderapi.acceptance.fixture

import com.lullaby.flab.restrauntfinderapi.application.restaurant.command.CreateRestaurantCommand
import com.lullaby.flab.restrauntfinderapi.application.restaurant.response.RestaurantResponse
import com.lullaby.flab.restrauntfinderapi.domain.FoodType
import io.restassured.RestAssured
import org.assertj.core.api.Assertions
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

fun 식당_생성(accessToken: String, name: String, address: String, tables: Int, foodType: FoodType): RestaurantResponse {
    val command = CreateRestaurantCommand( name, address, tables, foodType )
    val response = RestAssured
        .given().log().all()
        .header("Authorization", "Bearer $accessToken")
        .body(command)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .`when`().post("/restaurants")
        .then().log().all().extract()

    Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())

    return response.`as`(RestaurantResponse::class.java)
}
