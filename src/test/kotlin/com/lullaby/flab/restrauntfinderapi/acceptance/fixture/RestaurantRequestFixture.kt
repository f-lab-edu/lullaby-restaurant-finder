package com.lullaby.flab.restrauntfinderapi.acceptance.fixture

import com.lullaby.flab.restrauntfinderapi.application.restaurant.command.CreateRestaurantCommand
import com.lullaby.flab.restrauntfinderapi.application.restaurant.command.UpdateMenuCommand
import com.lullaby.flab.restrauntfinderapi.application.restaurant.response.RestaurantResponse
import com.lullaby.flab.restrauntfinderapi.domain.FoodType
import com.lullaby.flab.restrauntfinderapi.domain.MenuType
import io.restassured.RestAssured
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

fun 식당_생성(accessToken: String, name: String, address: String, tables: Int, foodType: FoodType): RestaurantResponse {
    val command = CreateRestaurantCommand(name, address, tables, foodType)
    val response = RestAssured
        .given().log().all()
        .header("Authorization", "Bearer $accessToken")
        .body(command)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .`when`().post("/restaurants")
        .then().log().all().extract()

    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())

    return response.`as`(RestaurantResponse::class.java)
}

fun 식당_조회(accessToken: String): List<RestaurantResponse> {
    val response = RestAssured
        .given().log().all()
        .header("Authorization", "Bearer $accessToken")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .`when`().get("/restaurants")
        .then().log().all().extract()

    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())

    return response.jsonPath().getList("", RestaurantResponse::class.java)
}

fun 식당_메뉴_추가(accessToken: String, restaurantId: Long, name: String, price: Int, type: String): RestaurantResponse {
    val command = mapOf(
        "name" to name,
        "price" to price,
        "type" to type
    )

    val response = RestAssured
        .given().log().all()
        .header("Authorization", "Bearer $accessToken")
        .body(command)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .`when`().post("/restaurants/$restaurantId/menus")
        .then().log().all().extract()

    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())

    return response.`as`(RestaurantResponse::class.java)
}

fun 식당_메뉴_수정(accessToken: String, restaurantId: Long, menuId: Long, name: String, price: Int, type: MenuType) {
    val command = UpdateMenuCommand(name, price, type)

    val response = RestAssured
        .given().log().all()
        .header("Authorization", "Bearer $accessToken")
        .body(command)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .`when`().put("/restaurants/$restaurantId/menus/${menuId}")
        .then().log().all().extract()

    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
}
