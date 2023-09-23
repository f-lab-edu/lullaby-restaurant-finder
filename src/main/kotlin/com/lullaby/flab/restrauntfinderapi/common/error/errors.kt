package com.lullaby.flab.restrauntfinderapi.common.error

import org.springframework.http.HttpStatus

sealed class HttpException(val httpStatus: HttpStatus, val statusText: String, message: String): RuntimeException(message)
class BadRequestException(statusText: String, message: String): HttpException(HttpStatus.BAD_REQUEST, statusText, message)
class UnauthorizedException(statusText: String, message: String): HttpException(HttpStatus.UNAUTHORIZED, statusText, message)
class ForbiddenException(statusText: String, message: String): HttpException(HttpStatus.FORBIDDEN, statusText, message)
class NotFoundException(statusText: String, message: String): HttpException(HttpStatus.NOT_FOUND, statusText, message)
class ConflictException(statusText: String, message: String): HttpException(HttpStatus.CONFLICT, statusText, message)

