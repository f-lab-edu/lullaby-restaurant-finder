package com.lullaby.flab.restrauntfinderapi.acceptance.fixture

import com.lullaby.flab.restrauntfinderapi.application.auth.request.SignInRequest
import com.lullaby.flab.restrauntfinderapi.application.auth.request.SignUpRequest
import io.restassured.RestAssured
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

fun 회원_가입(account: String, password: String) {
    val response = RestAssured
        .given().log().all()
        .body(SignUpRequest(account, password))
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .`when`().post("/sign-up")
        .then().log().all().extract()

    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())
}

fun 로그인(account: String, password: String): String {
    val response = RestAssured
        .given().log().all()
        .body(SignInRequest(account, password))
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .`when`().post("/sign-in")
        .then().log().all().extract()

    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())

    return response.jsonPath().getString("accessToken")
}
