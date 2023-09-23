package com.lullaby.flab.restrauntfinderapi.web

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

data class ErrorResponse(val status: Int, val error: String, val timestamp: String = ZonedDateTime.now().format(
    DateTimeFormatter.ISO_OFFSET_DATE_TIME))
