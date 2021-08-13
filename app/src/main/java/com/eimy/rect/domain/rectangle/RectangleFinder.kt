package com.eimy.rect.domain.rectangle

import com.eimy.rect.domain.model.BOARD_SIZE
import com.eimy.rect.domain.model.Rectangle
import com.eimy.rect.domain.rectangle.MaxHistFinder.maxHist
import kotlinx.coroutines.flow.flow

object RectangleFinder {

    suspend fun maxRectangle(rectangleList: List<IntArray>) = flow {
        var result = 0

        if (!rectangleList.isNullOrEmpty()) {
            result = maxHist(rectangleList[0])

            (1 until BOARD_SIZE).map { i ->
                (0 until BOARD_SIZE).map { j ->
                    if (rectangleList[i][j] == 1) rectangleList[i][j] += rectangleList[i - 1][j]
                }
                result = maxOf(result, maxHist(rectangleList[i]))
            }
        }

        emit(
            Rectangle(
                rectangleList, result
            )
        )
    }

}