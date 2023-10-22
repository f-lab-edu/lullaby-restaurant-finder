package com.lullaby.flab.restrauntfinderapi.application.restaurant

import com.lullaby.flab.restrauntfinderapi.application.restaurant.command.CreateMenuCommand
import com.lullaby.flab.restrauntfinderapi.application.restaurant.command.CreateRestaurantCommand
import com.lullaby.flab.restrauntfinderapi.application.restaurant.command.UpdateMenuCommand
import com.lullaby.flab.restrauntfinderapi.application.restaurant.response.RestaurantResponse
import com.lullaby.flab.restrauntfinderapi.domain.Restaurant
import com.lullaby.flab.restrauntfinderapi.domain.RestaurantRepository
import org.springframework.data.repository.findByIdOrNull
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

    fun list(): List<RestaurantResponse> = restaurantRepository.findAll().map(::RestaurantResponse)

    @Transactional
    fun createMenu(restaurantId: Long, request: CreateMenuCommand): RestaurantResponse {
        val restaurant = restaurantRepository.findByIdOrNull(restaurantId) ?: throw NotFoundRestaurantException()
        restaurant.addMenu(restaurant.name, request.price, request.type)
        restaurantRepository.save(restaurant)
        return RestaurantResponse(restaurant)
    }

    @Transactional
    fun updateMenu(restaurantId: Long, menuId: Long, command: UpdateMenuCommand) {
         val restaurant = restaurantRepository.findByIdOrNull(restaurantId) ?: throw NotFoundRestaurantException()
        val menu = restaurant.findMenuOrNull(menuId) ?: throw NotFoundMenuException()
        menu.update(command.name, command.price, command.type)
    }

    fun removeMenu(restaurantId: Long, menuId: Long) {
        val restaurant = restaurantRepository.findByIdOrNull(restaurantId) ?: throw NotFoundRestaurantException()
        val isRemoved = restaurant.removeMenu(menuId)
        if (!isRemoved) {
            throw NotFoundMenuException()
        }
    }
}
