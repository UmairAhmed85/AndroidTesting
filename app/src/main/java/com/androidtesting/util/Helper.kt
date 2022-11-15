package com.androidtesting.util

class Helper {

    fun isStringPallindromem(input: String): Boolean {
        var i = 0;
        var j = input.length - 1
        var result = true
        while (i < j) {
            if (input[i] != input[j]) {
                result = false
                break
            }
            i++
            j--
        }
        return result
    }

    /*
    Write test cases for below constraints
    Password should not be empty
    Password length should be in 6 to 15 characters
     */
    fun validatePassword(value: String?): String? {
        value?.let {
            if (value.length !in 6..15) {
                return null
            }
        } ?: return null

        return value
    }
}