package com.androidtesting

import android.content.Context
import com.google.gson.Gson
import java.lang.IndexOutOfBoundsException

class ColorManager {
    var colorsList = emptyArray<Color>()
    var currentColorIndex = 0

    fun populateColorsFromAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        colorsList = gson.fromJson(json, Array<Color>::class.java)
    }

    fun popularColors(colors: Array<Color>) {
        colorsList = colors
    }

    fun getCurrentColor(): Color {
        return colorsList[currentColorIndex]
    }

    fun getNextColor(): Color {
        return try {
            colorsList[++currentColorIndex]
        } catch (e: IndexOutOfBoundsException) {
            --currentColorIndex
            colorsList[currentColorIndex]
        }
    }

    fun getPreviousColor(): Color {
        return try {
            colorsList[--currentColorIndex]
        } catch (e: IndexOutOfBoundsException) {
            ++currentColorIndex
            colorsList[currentColorIndex]
        }
    }
}