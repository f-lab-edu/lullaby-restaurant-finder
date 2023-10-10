package com.lullaby.flab.restrauntfinderapi.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Menu(
    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var price: Int,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var type: MenuType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    val restaurant: Restaurant,

    id: Long = 0L,
): BaseEntity(id)

enum class MenuType {
    MAIN,
    SUB,
    BEVERAGE,
}
