package com.lullaby.flab.restrauntfinderapi.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Table(name = "users")
@Entity
class Member(
    @Column(nullable = false)
    val account: String,

    @Column(name  = "password", nullable = false)
    val encryptedPassword: String,

    id: Long = 0L,
): BaseEntity(id), UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return ArrayList()
    }

    override fun getPassword(): String = encryptedPassword

    override fun getUsername(): String = account

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}
