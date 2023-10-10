package com.lullaby.flab.restrauntfinderapi.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Menu(
    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var price: Int,

    @Column(nullable = false)
    var type: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    val restaurant: Restaurant,

    id: Long = 0L,
): BaseEntity(id) {

}
