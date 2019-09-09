package com.xebia.hpotier

import com.xebia.hpotier.data.remote.domain.Offer
import com.xebia.hpotier.util.CalculesUtils
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun calculatePercentage() {
        assertEquals(10, CalculesUtils.calculatePercentage(100, 10))
    }

    @Test
    fun calculateSlice(){
        assertEquals(0, CalculesUtils.calculateSlice(65, Offer(100, "slice", 12)))
        assertEquals(12, CalculesUtils.calculateSlice(165, Offer(100, "slice", 12)))
    }

    @Test
    fun calculeTotalDiscount(){
        assertEquals(50, CalculesUtils.calculeTotalDiscount(65, 15))
    }

    @Test
    fun calculateMaxOffre(){
        var listOffres : MutableList<Offer> = mutableListOf<Offer>()
        listOffres.add(Offer(0, "percentage", 4))
        listOffres.add(Offer(0, "minus", 15))
        listOffres.add(Offer(100, "slice", 12))
        assertEquals(15, CalculesUtils.calculateMaxOffre(65, listOffres))
    }
}