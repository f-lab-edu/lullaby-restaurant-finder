package com.lullaby.flab.restrauntfinderapi.application.restaurant

import com.lullaby.flab.restrauntfinderapi.common.error.NotFoundException
import com.lullaby.flab.restrauntfinderapi.common.error.UnauthorizedException

private const val statusText = "RestaurantFailException"

class CreateRestaurantFailException(message: String): UnauthorizedException(statusText, message)
class NotFoundRestaurantException(): NotFoundException(statusText, "존재 하지 않는 식당 입니다.")
