package com.lullaby.flab.restrauntfinderapi.web

import com.lullaby.flab.restrauntfinderapi.application.restaurant.RestaurantService
import com.lullaby.flab.restrauntfinderapi.application.restaurant.command.CreateRestaurantCommand
import com.lullaby.flab.restrauntfinderapi.application.restaurant.response.RestaurantResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class RestaurantController(
    val restaurantService: RestaurantService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/restaurants")
    fun createRestaurant(@RequestBody request: CreateRestaurantCommand): RestaurantResponse
        = restaurantService.create(request)

}
