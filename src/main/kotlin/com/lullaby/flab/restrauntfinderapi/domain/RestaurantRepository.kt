package com.lullaby.flab.restrauntfinderapi.domain

import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantRepository: JpaRepository<Restaurant, Long>
