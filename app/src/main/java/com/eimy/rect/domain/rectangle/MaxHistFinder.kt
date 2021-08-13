package com.eimy.rect.domain.rectangle

import com.eimy.rect.domain.model.BOARD_SIZE
import java.util.*

object MaxHistFinder {

    fun maxHist(row: IntArray): Int {

        val result = Stack<Int>()
        var maxArea = 0
        var i = 0
        while (i < BOARD_SIZE) {

            if (result.empty()
                || row[result.peek()] <= row[i]
            ) {
                result.push(i++)

            } else {

                maxArea = getMaxArea(row, result, i, maxArea)
            }
        }

        while (!result.empty()) {
            maxArea = getMaxArea(row, result, i, maxArea)
        }
        return maxArea
    }

    private fun getMaxArea(
        row: IntArray,
        result: Stack<Int>,
        index: Int,
        maxArea: Int,
    ): Int {
        val topValue = row[result.peek()]
        result.pop()
        var area = topValue * index
        if (!result.empty()) area = topValue * (index - result.peek() - 1)
        return maxOf(area, maxArea)
    }


}