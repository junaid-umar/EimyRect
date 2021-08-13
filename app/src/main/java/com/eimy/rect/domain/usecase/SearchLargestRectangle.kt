package com.eimy.rect.domain.usecase

import com.eimy.rect.domain.model.Rectangle
import com.eimy.rect.domain.rectangle.RectangleFinder
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchLargestRectangle
@Inject constructor(
    private val rectangleFinder: RectangleFinder
) {
    suspend fun execute(rectangleArray: List<IntArray>): Flow<Rectangle> {
        return rectangleFinder.maxRectangle(rectangleArray)
    }
}