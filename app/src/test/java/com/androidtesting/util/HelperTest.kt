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

    @Test
    fun validatePassword_inputString_expectedTrue() {
        // Act
        val resultValid = helper.validatePassword("valid_password")
        // Assert
        assertNotNull("valid", resultValid)
    }

    @Test
    fun validatePassword_inputStringLongerThanMaxLimit_expectedFalse() {
        // Act
        val resultInvalid = helper.validatePassword("not_a_valid_password_its_too_long")
        // Assert
        assertNull("invalid", resultInvalid)
    }

    @Test
    fun validatePassword_inputStringShorterThanMinLimit_expectedFalse() {
        // Act
        val resultInvalid = helper.validatePassword("short")
        // Assert
        assertNull("invalid", resultInvalid)
    }

    @Test
    fun validatePassword_inputString_expectedNull() {
        // Act
        val resultInvalid = helper.validatePassword(null)
        // Assert
        assertNull("invalid", resultInvalid)
    }


}
