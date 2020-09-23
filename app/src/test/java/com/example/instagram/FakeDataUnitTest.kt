package com.example.instagram

import android.content.Context
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class FakeDataUnitTest {

    @Before
    fun setup() {
    }

    @Test
    fun addition_isCorrect() {
        val context = mock(Context::class.java)
        val map = HashMap<String, String>()
        map.put("0", "string0")
        map.put("1", "string1")

        Mockito.`when`<Any>(FakeNetworkModel().getFakeData(context)).thenReturn(
            map
        )

        val testMap = FakeNetworkModel().getFakeData(context)

        assertThat(testMap, instanceOf(Map::class.java))
        assertEquals(testMap?.size, 2)
    }

}