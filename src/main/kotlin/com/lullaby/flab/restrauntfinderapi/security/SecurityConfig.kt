package com.lullaby.flab.restrauntfinderapi.security

import com.lullaby.flab.restrauntfinderapi.application.auth.AuthService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig(
    val authenticationFailHandler: AuthenticationFailHandler,
    val authService: AuthService,
) {

    private val allowedUrls = arrayOf("/sign-up", "/sign-in", "/error")

    @Bean
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        return httpSecurity
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers(*allowedUrls).permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterBefore(JwtFilter(authService), UsernamePasswordAuthenticationFilter::class.java)
            .exceptionHandling {
                it.authenticationEntryPoint(authenticationFailHandler)
            }
            .formLogin { it.disable() }
            .build()
    }

}
