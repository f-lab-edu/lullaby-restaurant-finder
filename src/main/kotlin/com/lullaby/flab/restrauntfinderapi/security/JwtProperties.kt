package com.lullaby.flab.restrauntfinderapi.security

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("application.jwt")

data class JwtProperties(val secret: String, val expires: Expires) {
    data class Expires(val accessToken: Long, val refreshToken: Long)
}
