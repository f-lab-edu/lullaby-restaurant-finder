package com.lullaby.flab.restrauntfinderapi.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Entity
class Restaurant(
    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val address: String,

    @Column(nullable = false)
    var tables: Int,

    @Enumerated(EnumType.STRING)
    val foodType: FoodType,

    id: Long = 0L,
): BaseEntity()

enum class FoodType {
    KOREAN,
    JAPANESE,
    CHINESE,
    ASIAN,
    WESTERN
}
