package com.lullaby.flab.restrauntfinderapi.application.auth.response

import com.lullaby.flab.restrauntfinderapi.domain.Member

data class SignUpResponse(val memberId: Long, val account: String) {
    constructor(member: Member): this(member.id, member.account)
}
