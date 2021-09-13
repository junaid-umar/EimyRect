package com.eimy.rect.domain.rectangle

import android.util.Log
import com.eimy.rect.domain.model.BOARD_SIZE
import com.eimy.rect.domain.model.Rectangle
import com.eimy.rect.domain.rectangle.MaxHistFinder.maxHist
import kotlinx.coroutines.flow.flow

object RectangleFinder {

    suspend fun maxRectangle(rectangleList: List<IntArray>) = flow {


        val result = maxHistRectangles(rectangleList.map { it.copyOf() })

        result.second.map {largestRectangle ->
            largestRectangle.second.map { column ->
                rectangleList[largestRectangle.first][column] = 2
            }
        }

        emit(
            Rectangle(
                rectangleList, result.first
            )
        )
    }

    private fun maxHistRectangles(rectangleList: List<IntArray>):
            Pair<Int, List<Pair<Int, IntArray>>> {

        var result: Pair<Int, List<Pair<Int, IntArray>>> = Pair(0, listOf())

        if (!rectangleList.isNullOrEmpty()) {
            result = maxHist(rectangleList[0], 0)

            (1 until BOARD_SIZE).map { i ->
                (0 until BOARD_SIZE).map { j ->
                    if (rectangleList[i][j] == 1) rectangleList[i][j] += rectangleList[i - 1][j]
                }
                val rowResult = maxHist(rectangleList[i], i)
                result = if (result.first < rowResult.first)
                    result
                else
                    rowResult
            }
        }
        return result
    }

}