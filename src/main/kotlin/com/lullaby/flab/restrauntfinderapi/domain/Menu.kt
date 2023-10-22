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
): BaseEntity(id) {

    init {
        validate()
    }
    private fun validate() {
        check(name.isNotBlank()) { "메뉴 이름을 입력 해야 합니다." }
        check(price >= 0) { "메뉴 가격은 0 보다 작을 수 없습니다." }
    }
    fun update(name: String, price: Int, type: MenuType) {
        this.name = name
        this.price = price
        this.type = type
        validate()
    }


}

enum class MenuType {
    MAIN,
    SUB,
    BEVERAGE,
}
