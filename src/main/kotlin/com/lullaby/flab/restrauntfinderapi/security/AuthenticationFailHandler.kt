package com.lullaby.flab.restrauntfinderapi.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.lullaby.flab.restrauntfinderapi.web.ErrorResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component

@Component
class AuthenticationFailHandler : AuthenticationEntryPoint {

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        // 유효한 자격 증명을 제공 하지 않고 접근 하려 할때 401
        response.status = HttpServletResponse.SC_UNAUTHORIZED
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.print(errorResponse())
    }

    private fun errorResponse() = objectMapper.writeValueAsString(
        ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "Unauthorized")
    )

    companion object {
        private val objectMapper: ObjectMapper = ObjectMapper()
    }
}
