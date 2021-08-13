package com.eimy.rect.domain.model

data class Rectangle(
    val rectangleList: List<IntArray>,
    val rectangleSize: Int
)

const val BOARD_SIZE = 15