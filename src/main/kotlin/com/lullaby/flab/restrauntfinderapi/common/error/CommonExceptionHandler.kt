package com.lullaby.flab.restrauntfinderapi.common.error

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CommonExceptionHandler {

    @ExceptionHandler(HttpException::class)
    fun httpException(exception: HttpException): ResponseEntity<ErrorResponse> = ResponseEntity
        .status(exception.httpStatus.value())
        .body(ErrorResponse(exception))
}
