package com.lullaby.flab.restrauntfinderapi.application

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class PasswordEncryptService {
    private val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder(10)

    fun encrypt(rawPassword: String) = passwordEncoder.encode(rawPassword)

    fun match(rawPassword: String, encryptedPassword: String) = passwordEncoder.matches(rawPassword, encryptedPassword)
}
