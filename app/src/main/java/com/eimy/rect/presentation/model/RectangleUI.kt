package com.eimy.rect.presentation.model

data class RectangleUI(
    var rectangleList: MutableList<RectangleType>,
    var largestRectangle: Int = 0
)

enum class RectangleType {
    NOT_SELECTED, SELECTED, LARGEST
}

