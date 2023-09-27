package com.lullaby.flab.restrauntfinderapi.application.restaurant

import com.lullaby.flab.restrauntfinderapi.common.error.UnauthorizedException

private const val statusText = "RestaurantFailException"

class CreateRestaurantFailException(message: String): UnauthorizedException(statusText, message)
