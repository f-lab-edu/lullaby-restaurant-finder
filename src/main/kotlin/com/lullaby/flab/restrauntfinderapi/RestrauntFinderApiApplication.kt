package com.lullaby.flab.restrauntfinderapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class RestrauntFinderApiApplication

fun main(args: Array<String>) {
	runApplication<RestrauntFinderApiApplication>(*args)
}
