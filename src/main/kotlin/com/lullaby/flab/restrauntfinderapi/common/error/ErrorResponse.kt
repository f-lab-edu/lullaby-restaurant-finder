package com.lullaby.flab.restrauntfinderapi.common.error

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

data class ErrorResponse(
    val status: Int,
    val statusText: String,
    val message: String,
    val timestamp: String = ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
) {
    constructor(httpException: HttpException): this(httpException.httpStatus.value(), httpException.statusText, httpException.message ?: "")

}
