package com.eimy.rect.domain.rectangle

import com.eimy.rect.FakeDataUtil.Domain.rowOf0
import com.eimy.rect.FakeDataUtil.Domain.rowOf1
import com.eimy.rect.domain.model.BOARD_SIZE
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class MaxHistFinderTest {


    @Test
    fun `given row of 0 returns 0`() {
        val result = MaxHistFinder.maxHist(rowOf0)

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `given array of 1 returns maxHist`() {
        val result = MaxHistFinder.maxHist(rowOf1)

        assertThat(result).isEqualTo(BOARD_SIZE)
    }
}