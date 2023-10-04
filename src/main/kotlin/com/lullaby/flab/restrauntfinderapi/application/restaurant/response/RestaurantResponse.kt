package com.lullaby.flab.restrauntfinderapi.application.restaurant.response

import com.lullaby.flab.restrauntfinderapi.domain.FoodType
import com.lullaby.flab.restrauntfinderapi.domain.Restaurant
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

data class RestaurantResponse(
    val name: String,
    val address: String,
    var tables: Int,
    val foodType: FoodType,
    val id: Long,
) {
    constructor(restaurant: Restaurant): this(
        restaurant.name,
        restaurant.address,
        restaurant.tables,
        restaurant.foodType,
        restaurant.id
    )
}
