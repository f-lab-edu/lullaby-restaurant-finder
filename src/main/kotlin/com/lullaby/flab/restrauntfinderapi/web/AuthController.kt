package com.lullaby.flab.restrauntfinderapi.web

import com.lullaby.flab.restrauntfinderapi.application.AuthService
import com.lullaby.flab.restrauntfinderapi.application.request.SignInRequest
import com.lullaby.flab.restrauntfinderapi.application.request.SignUpRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    val authService: AuthService,
) {
    @PostMapping("sign-in")
    fun signIn(@RequestBody request: SignInRequest) = authService.signIn(request)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("sign-up")
    fun signUp(@RequestBody request: SignUpRequest) = authService.signUp(request)

}
