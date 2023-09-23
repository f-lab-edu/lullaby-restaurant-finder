package com.lullaby.flab.restrauntfinderapi.application.auth

import com.lullaby.flab.restrauntfinderapi.common.error.ConflictException
import com.lullaby.flab.restrauntfinderapi.common.error.UnauthorizedException

private const val statusText: String = "AuthFailException"

class InvalidTokenException: UnauthorizedException(statusText, "유효 하지 않은 토큰 입니다.")
class MemberNotFoundException: UnauthorizedException(statusText, "인증에 실패 하였습니다.")
class IncorrectPasswordException: UnauthorizedException(statusText, "인증에 실패 하였습니다.")
class AlreadyExistMemberException: ConflictException(statusText, "인증에 실패 하였습니다.")
