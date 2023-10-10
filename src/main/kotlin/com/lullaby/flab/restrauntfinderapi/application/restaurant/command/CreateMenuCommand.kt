package com.lullaby.flab.restrauntfinderapi.application.restaurant.command

data class CreateMenuCommand (
    val name: String,
    val price: Int,
    val type: String,
)
