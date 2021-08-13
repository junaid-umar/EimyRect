package com.eimy.rect.domain.usecase

import com.eimy.rect.FakeDataUtil
import com.eimy.rect.domain.model.Rectangle
import com.eimy.rect.domain.rectangle.RectangleFinder
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class SearchLargestRectangleTest {

    private lateinit var searchLargestRectangle: SearchLargestRectangle


    private lateinit var rectangleFinder: RectangleFinder

    @BeforeEach
    fun setUp() {
        rectangleFinder = mockk()
        searchLargestRectangle = SearchLargestRectangle(
            rectangleFinder
        )

    }

    @ExperimentalCoroutinesApi
    @Test
    fun `search max rectangle when given array`() = runBlockingTest {
        val input = Rectangle(
            FakeDataUtil.Domain.rectangleListOf1,
            0
        )

        coEvery {
            rectangleFinder.maxRectangle(FakeDataUtil.Domain.rectangleListOf1)
        } returns flow {
            emit(
                input
            )
        }
        assertThat(
            searchLargestRectangle.execute(FakeDataUtil.Domain.rectangleListOf1).first()
        ).isEqualTo(
            input
        )


    }
}