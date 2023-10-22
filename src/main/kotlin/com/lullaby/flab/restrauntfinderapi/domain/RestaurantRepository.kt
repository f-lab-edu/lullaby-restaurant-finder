package com.lullaby.flab.restrauntfinderapi.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RestaurantRepository: JpaRepository<Restaurant, Long> {

    @Query("select r from Restaurant r left join fetch r.menus")
    override fun findAll(): List<Restaurant>

}
