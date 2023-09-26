package com.lullaby.flab.restrauntfinderapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class RestaurantFinderApiApplication

fun main(args: Array<String>) {
	runApplication<RestaurantFinderApiApplication>(*args)
}
