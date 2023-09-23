package com.lullaby.flab.restrauntfinderapi.common.error

import org.springframework.http.HttpStatus

sealed class HttpException(val httpStatus: HttpStatus, val statusText: String, message: String): RuntimeException(message)
open class BadRequestException(statusText: String, message: String): HttpException(HttpStatus.BAD_REQUEST, statusText, message)
open class UnauthorizedException(statusText: String, message: String): HttpException(HttpStatus.UNAUTHORIZED, statusText, message)
open class ForbiddenException(statusText: String, message: String): HttpException(HttpStatus.FORBIDDEN, statusText, message)
open class NotFoundException(statusText: String, message: String): HttpException(HttpStatus.NOT_FOUND, statusText, message)
open class ConflictException(statusText: String, message: String): HttpException(HttpStatus.CONFLICT, statusText, message)

