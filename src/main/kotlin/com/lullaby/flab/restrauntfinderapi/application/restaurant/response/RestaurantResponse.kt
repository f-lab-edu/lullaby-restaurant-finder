package com.lullaby.flab.restrauntfinderapi.application.restaurant.response

import com.lullaby.flab.restrauntfinderapi.domain.FoodType
import com.lullaby.flab.restrauntfinderapi.domain.Menu
import com.lullaby.flab.restrauntfinderapi.domain.MenuType
import com.lullaby.flab.restrauntfinderapi.domain.Restaurant
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

data class RestaurantResponse(
    val name: String,
    val address: String,
    var tables: Int,
    val foodType: FoodType,
    val menus: List<MenuResponse>,
    val id: Long,
) {
    constructor(restaurant: Restaurant): this(
        restaurant.name,
        restaurant.address,
        restaurant.tables,
        restaurant.foodType,
        restaurant.getMenus().map(::MenuResponse),
        restaurant.id
    )

    data class MenuResponse(val name: String, val price: Int, val type: MenuType, val id: Long) {
        constructor(menu: Menu): this(menu.name, menu.price, menu.type, menu.id)
    }
}
