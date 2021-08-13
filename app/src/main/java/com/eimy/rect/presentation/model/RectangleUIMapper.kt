package com.eimy.rect.presentation.model

import com.eimy.rect.domain.model.BOARD_SIZE
import com.eimy.rect.domain.model.Rectangle
import com.eimy.rect.domain.util.DomainMapper

class RectangleUIMapper : DomainMapper<RectangleUI, Rectangle> {
    override fun mapToDomainModel(model: RectangleUI): Rectangle {
        return Rectangle(
            rectangleList = model.rectangleList.toDomainList(),
            model.largestRectangle
        )
    }

    override fun mapFromDomainModel(domain: Rectangle): RectangleUI {
        return RectangleUI(
            rectangleList = domain.rectangleList.map {
                it.map {
                    it.toRectangleType()
                }

            }.flatten().toMutableList(), domain.rectangleSize
        )
    }
}

fun MutableList<RectangleType>.toDomainList(): List<IntArray> {
    return this.chunked(BOARD_SIZE).map {
        it.map {
            it.rectangleTypeToInt()
        }.toIntArray()
    }
}

fun Int.toRectangleType(): RectangleType {
    return when (this) {
        0 -> RectangleType.NOT_SELECTED
        1 -> RectangleType.SELECTED
        else -> RectangleType.SELECTED
    }
}

fun RectangleType.rectangleTypeToInt(): Int {
    return when (this) {
        RectangleType.NOT_SELECTED -> 0
        RectangleType.SELECTED -> 1
        RectangleType.LARGEST -> 1
    }
}


fun RectangleType.changeRectangleType(): RectangleType {
    return when (this) {
        RectangleType.NOT_SELECTED -> RectangleType.SELECTED
        RectangleType.SELECTED -> RectangleType.NOT_SELECTED
        RectangleType.LARGEST -> RectangleType.NOT_SELECTED
    }

}