package com.lullaby.flab.restrauntfinderapi.application.restaurant.command

import com.lullaby.flab.restrauntfinderapi.domain.MenuType

data class CreateMenuCommand (
    val name: String,
    val price: Int,
    val type: MenuType,
)
