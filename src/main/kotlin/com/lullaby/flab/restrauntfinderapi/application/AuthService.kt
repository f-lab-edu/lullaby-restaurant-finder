package com.lullaby.flab.restrauntfinderapi.application

import com.lullaby.flab.restrauntfinderapi.application.request.SignInRequest
import com.lullaby.flab.restrauntfinderapi.application.request.SignUpRequest
import com.lullaby.flab.restrauntfinderapi.application.response.SignInResponse
import com.lullaby.flab.restrauntfinderapi.application.response.SignUpResponse
import com.lullaby.flab.restrauntfinderapi.domain.Member
import com.lullaby.flab.restrauntfinderapi.domain.MemberRepository
import com.lullaby.flab.restrauntfinderapi.security.TokenProvider
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class AuthService(
    val memberRepository: MemberRepository,
    val passwordEncryptService: PasswordEncryptService,
    val tokenProvider: TokenProvider,
) {

    fun signUp(request: SignUpRequest): SignUpResponse {
        check(!memberRepository.existsByAccount(request.account)) { "이미 존재 하는 계정명 입니다." }
        val encodedPassword = passwordEncryptService.encrypt(request.password)
        val user = Member(request.account, encodedPassword)
        return memberRepository.save(user).let(::SignUpResponse)
    }
    fun signIn(request: SignInRequest): SignInResponse {
        val user = memberRepository.findByAccount(request.account) ?: throw RuntimeException()
        if (!passwordEncryptService.match(request.password, user.encryptedPassword)) {
            throw RuntimeException()
        }

        return SignInResponse(
            tokenProvider.accessToken(user.id),
            tokenProvider.refreshToken(user.id)
        )
    }

    fun authenticate(accessToken: String): Authentication {
        if (!tokenProvider.validateToken(accessToken)) {
            throw RuntimeException()
        }

        val claims = tokenProvider.parseToken(accessToken)
        val user = memberRepository.findByIdOrNull(claims.subject.toLong()) ?: throw RuntimeException()
        return UsernamePasswordAuthenticationToken(user, null, listOf())
    }

}
