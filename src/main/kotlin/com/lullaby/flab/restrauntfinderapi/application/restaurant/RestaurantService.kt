package com.lullaby.flab.restrauntfinderapi.application.restaurant

import com.lullaby.flab.restrauntfinderapi.application.restaurant.command.CreateRestaurantCommand
import com.lullaby.flab.restrauntfinderapi.application.restaurant.response.RestaurantResponse
import com.lullaby.flab.restrauntfinderapi.domain.Restaurant
import com.lullaby.flab.restrauntfinderapi.domain.RestaurantRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RestaurantService(
    val restaurantRepository: RestaurantRepository,
) {

    @Transactional
    fun create(command: CreateRestaurantCommand): RestaurantResponse {
        val restaurant = Restaurant(command.name, command.address, command.tables, command.foodType)
        return restaurantRepository.save(restaurant)
            .run(::RestaurantResponse)
    }

}
