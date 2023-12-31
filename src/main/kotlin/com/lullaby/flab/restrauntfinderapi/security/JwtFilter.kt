package com.lullaby.flab.restrauntfinderapi.security

import com.lullaby.flab.restrauntfinderapi.application.auth.AuthService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtFilter(
    val authService: AuthService,
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val jwt = resolveToken(request)

        if (jwt != null) {
            val authentication = authService.authenticate(jwt)
            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }

    private fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(AUTHORIZATION_HEADER) ?: return null
        return if (bearerToken.startsWith(BEARER_TOKEN_PREFIX)) bearerToken.substring(BEARER_TOKEN_LENGTH) else null
    }

    companion object {
        const val AUTHORIZATION_HEADER = "Authorization"
        const val BEARER_TOKEN_PREFIX = "Bearer "
        const val BEARER_TOKEN_LENGTH = BEARER_TOKEN_PREFIX.length
    }

}
