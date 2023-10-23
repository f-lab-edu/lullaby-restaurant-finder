package com.lullaby.flab.restrauntfinderapi.security

import com.fasterxml.jackson.core.json.JsonWriteFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.lullaby.flab.restrauntfinderapi.common.error.ErrorResponse
import com.lullaby.flab.restrauntfinderapi.common.error.UnauthorizedException
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
        response.status = HttpStatus.UNAUTHORIZED.value()
        response.contentType = MediaType.APPLICATION_JSON_UTF8.toString()
        response.writer.print(messageTemplate)
    }
    companion object {
        private val objectMapper: ObjectMapper = ObjectMapper()
        private val messageTemplate: String =
            objectMapper.writeValueAsString(ErrorResponse(UnauthorizedException("AuthException", "인증에 실패 하였습니다.")))
    }
}
