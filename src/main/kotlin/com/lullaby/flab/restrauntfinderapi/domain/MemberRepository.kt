package com.lullaby.flab.restrauntfinderapi.domain

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
    fun findByAccount(account: String): Member?
    fun existsByAccount(account: String): Boolean
}
