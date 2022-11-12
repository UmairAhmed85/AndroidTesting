package com.androidtesting.util

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParametrizeTestCases(val inputString: String, val expectedValue: Boolean) {

    @Test
    fun TestMyTestCase() {
        val helper = Helper()
        val result = helper.isStringPallindromem(inputString)
        assertEquals(expectedValue, result)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is pallindrome - {1} ")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }

}