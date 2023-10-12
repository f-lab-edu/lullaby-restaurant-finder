package com.lullaby.flab.restrauntfinderapi.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MenuTest {

    val restaurant = Restaurant("쉐이크쉑 강남대로점", "서울 서초구 강남대로 421", 30, FoodType.WESTERN)
    @DisplayName("메뉴를 생성 한다.")
    @Test
    fun create_success() {
        val menu = Menu("쉑버거", 8400, MenuType.MAIN,  restaurant)
    }

    @DisplayName("메뉴를 생성 시, 이름을 입력하지 않으면 실패 한다.")
    @Test
    fun create_fail_1() {
        assertThrows<IllegalStateException> { Menu("", 8400, MenuType.MAIN,  restaurant) }
        assertThrows<IllegalStateException> { Menu(" ", 8400, MenuType.MAIN,  restaurant) }
    }

    @DisplayName("메뉴를 생성 시, 메뉴 가격이 0 보다 작으면 실패 한다.")
    @Test
    fun create_fail_2() {
        assertThrows<IllegalStateException> { Menu("쉑버거", -1, MenuType.MAIN,  restaurant) }
    }

    @DisplayName("메뉴를 수정 한다.")
    @Test
    fun update_success() {
        val menu = Menu("쉑버거", 8400, MenuType.MAIN,  restaurant)
        menu.update("쉐이크", 6500, MenuType.BEVERAGE)

        assertThat(menu.name).isEqualTo("쉐이크")
        assertThat(menu.price).isEqualTo(6500)
        assertThat(menu.type).isEqualTo(MenuType.BEVERAGE)
    }

    @DisplayName("메뉴를 수정 시, 이름을 입력하지 않으면 실패 한다.")
    @Test
    fun update_fail_1() {
        val menu = Menu("쉑버거", 8400, MenuType.MAIN,  restaurant)
        assertThrows<IllegalStateException> { menu.update("", 6500, MenuType.BEVERAGE) }
        assertThrows<IllegalStateException> { menu.update(" ", 6500, MenuType.BEVERAGE) }
    }
    @DisplayName("메뉴를 수정 시, 가격이 0 보다 작으면 실패 한다.")
    @Test
    fun update_fail_2() {
        val menu = Menu("쉑버거", 8400, MenuType.MAIN,  restaurant)
        assertThrows<IllegalStateException> { menu.update("쉐이크", -1, MenuType.BEVERAGE) }
    }

}

