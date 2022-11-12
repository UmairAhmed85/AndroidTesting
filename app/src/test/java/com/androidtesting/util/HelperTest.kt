package com.androidtesting.util

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    /*
    // Testing is like AAA rule
    1). Arrange
    2). Act
    3). Assert
     */
    private lateinit var helper: Helper

    @Before
    fun setUp() {
        // Arrange
        helper = Helper()
    }

    @After
    fun tearDown() {
        println("Test finished")
    }

    @Test
    fun isStringPallindrome_inputString_expectedFalse() {
        // Act
        val resultHello = helper.isStringPallindromem("hello")
        // Assert
        assertEquals(false, resultHello)
    }


    @Test
    fun isStringPallindrome_inputString_expectedTrue() {
        // Act
        val resultLevel = helper.isStringPallindromem("level")
        // Assert
        assertEquals(true, resultLevel)
    }

}
