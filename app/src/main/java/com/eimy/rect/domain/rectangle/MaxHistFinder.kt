package com.eimy.rect.domain.rectangle

import com.eimy.rect.domain.model.BOARD_SIZE
import java.util.*

object MaxHistFinder {

    fun maxHist(row: IntArray, rowNum: Int): Pair<Int, List<Pair<Int, IntArray>>> {

        val result = Stack<Int>()
        var maxArea: Pair<Int, List<Pair<Int, IntArray>>> = Pair(0, listOf())
        var i = 0
        while (i < BOARD_SIZE) {

            if (result.empty()
                || row[result.peek()] <= row[i]
            ) {
                result.push(i++)

            } else {

                maxArea = getMaxArea(row, result, i, maxArea, rowNum)
            }
        }

        while (!result.empty()) {
            maxArea = getMaxArea(row, result, i, maxArea, rowNum)
        }
        return maxArea
    }

    private fun getMaxArea(
        row: IntArray,
        result: Stack<Int>,
        index: Int,
        maxArea: Pair<Int, List<Pair<Int, IntArray>>>,
        rowNum: Int,
    ): Pair<Int, List<Pair<Int, IntArray>>> {

        val peakIndex = result.peek()
        val topValue = row[peakIndex]
        result.pop()

        var area = topValue * index

        if (!result.empty()) {
            area = topValue * (index - result.peek() - 1)
        }
        return if (area > maxArea.first) {
            val rectangleLocation = mutableListOf<Pair<Int, IntArray>>()
            listOf(0 until topValue).flatten().map {
                rectangleLocation.add(Pair(rowNum - it,
                    (peakIndex until index).toList().toIntArray()))
            }
            Pair(area, rectangleLocation)
        } else {
            maxArea
        }
    }


}