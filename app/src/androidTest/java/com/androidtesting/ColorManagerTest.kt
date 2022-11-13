package com.androidtesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import java.io.FileNotFoundException

class ColorManagerTest {

    lateinit var colorManager: ColorManager
    lateinit var context: Context

    @Before
    fun setUp() {
        // Arrange
        colorManager = ColorManager()
        context = ApplicationProvider.getApplicationContext()
    }

    @After
    fun tearDown() {
    }

    @Test(expected = FileNotFoundException::class)
    fun populateColorsFromAssets() {
        // Act
        colorManager.populateColorsFromAssets(
            context = context,
            fileName = ""
        )
    }

    @Test(expected = JsonSyntaxException::class)
    fun populateColorsFromAssets_InvalidJson_Expected_Exception() {
        // Act
        colorManager.populateColorsFromAssets(
            context = context,
            fileName = "invalid_syntax_colors.json"
        )
    }

    @Test
    fun populateColorsFromAssets_ValidJson_Expected_Count() {
        // Act
        colorManager.populateColorsFromAssets(
            context = context,
            fileName = "colors.json"
        )
        // Assert
        assertEquals(7, colorManager.colorsList.size)
    }

    @Test
    fun testPreviousColors_Expected_Correct_Color() {
        colorManager.popularColors(
            arrayOf(
                Color(color = "Dark Blue", value = "#123"),
                Color(color = "Pink", value = "#456"),
                Color(color = "Purple", value = "#789"),
            )
        )
        colorManager.currentColorIndex = 3

        // Act
        val previousColor = colorManager.getPreviousColor()

        // Assert
        assertEquals("Purple", previousColor.color)
    }

    @Test
    fun testNextColors_Expected_Correct_Color() {
        colorManager.popularColors(
            arrayOf(
                Color(color = "Dark Blue", value = "#123"),
                Color(color = "Pink", value = "#456"),
                Color(color = "Purple", value = "#456"),
            )
        )

        // Act
        val nextColor = colorManager.getNextColor()

        // Assert
        assertEquals("Pink", nextColor.color)
    }
}