package com.lullaby.flab.restrauntfinderapi.application.restaurant.command

import com.lullaby.flab.restrauntfinderapi.domain.FoodType

data class CreateRestaurantCommand(
    val name: String,
    val address: String,
    val tables: Int,
    val foodType: FoodType,
)
