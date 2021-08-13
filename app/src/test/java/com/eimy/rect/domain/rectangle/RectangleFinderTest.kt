package com.eimy.rect.domain.rectangle

import app.cash.turbine.test
import com.eimy.rect.FakeDataUtil.Domain.rectangleListOf0
import com.eimy.rect.FakeDataUtil.Domain.rectangleListOf1
import com.eimy.rect.FakeDataUtil.Domain.rectangleListOfRandom
import com.eimy.rect.domain.model.BOARD_SIZE
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
class RectangleFinderTest {


    @Test
    fun `given list of 0 return maximum 0`() = runBlocking {
        RectangleFinder.maxRectangle(rectangleListOf0).test {
            val rectangle = awaitItem()
            assertThat(rectangle.rectangleSize).isEqualTo(0)
            awaitComplete()
        }
    }

    @Test
    fun `given list of 1 return maximum hist`() = runBlocking {
        RectangleFinder.maxRectangle(rectangleListOf1).test {
            val rectangle = awaitItem()
            assertThat(rectangle.rectangleSize).isEqualTo(BOARD_SIZE * BOARD_SIZE)
            awaitComplete()
        }
    }


    @Test
    fun `given empty list return maximum 0`() = runBlocking {
        RectangleFinder.maxRectangle(emptyList()).test {
            val rectangle = awaitItem()
            assertThat(rectangle.rectangleSize).isEqualTo(0)
            awaitComplete()
        }
    }


    @Test
    fun `given list return maximum hist`() = runBlocking {
        RectangleFinder.maxRectangle(rectangleListOfRandom).test {
            val rectangle = awaitItem()
            assertThat(rectangle.rectangleSize).isEqualTo(BOARD_SIZE)
            awaitComplete()
        }
    }

}