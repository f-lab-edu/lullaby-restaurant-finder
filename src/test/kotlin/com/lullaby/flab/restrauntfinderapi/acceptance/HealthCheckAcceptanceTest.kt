package com.lullaby.flab.restrauntfinderapi.acceptance

import io.restassured.RestAssured
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType

class HealthCheckAcceptanceTest: AcceptanceTest() {
    @Test
    fun healthCheck() {
        val response = RestAssured
            .given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .`when`().get("/health-check")
            .then().log().all().extract()

        assertThat(response.statusCode()).isEqualTo(200)
    }
}
