package com.eimy.rect

import com.eimy.rect.domain.model.BOARD_SIZE

class FakeDataUtil {

    object Domain {

        val rectangleListOf1 = Array(BOARD_SIZE * BOARD_SIZE) {
            IntArray(BOARD_SIZE * BOARD_SIZE) { 1 }
        }.toList()

        val rectangleListOfRandom = Array(BOARD_SIZE * BOARD_SIZE) {
            IntArray(BOARD_SIZE * BOARD_SIZE) { index -> index % 2 }
        }.toList()


        val rectangleListOf0 = Array(BOARD_SIZE * BOARD_SIZE) {
            IntArray(BOARD_SIZE * BOARD_SIZE) { 0 }
        }.toList()

        val rowOf1 = IntArray(BOARD_SIZE) { 1 }
        val rowOf0 = IntArray(BOARD_SIZE) { 0 }
    }
}