package com.lullaby.flab.restrauntfinderapi.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany

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
): BaseEntity() {

    @OneToMany(mappedBy = "restaurant", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val menus: MutableList<Menu> = mutableListOf()

    fun addMenu(name: String, price: Int, type: MenuType) {
        menus.add(Menu(name, price, type, this))
    }

}

enum class FoodType {
    KOREAN,
    JAPANESE,
    CHINESE,
    ASIAN,
    WESTERN
}
