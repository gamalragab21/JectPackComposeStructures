package com.developers.jectpackcomposestructures.common.utils

import android.util.Patterns
import java.util.regex.Matcher
import java.util.regex.Pattern

object MyAppValidation {

    fun optionOneForPassword(password: String): Boolean {
        val specialPass = Pattern.compile("[.!@#\$%&*()_+=|<>?{}\\\\\\[\\]~-]")
        val passContainCars = specialPass.matcher(password)
        return password.length >= 6 && passContainCars.find()
    }

    fun optionTwoForPassword(password: String): Boolean {
        val patUpperCase = Pattern.compile("[A-Z][^A-Z]*$")
        val patLowerCase = Pattern.compile("[a-z][^a-z]*$")
        val matchUpper: Matcher = patUpperCase.matcher(password)
        val matchLower: Matcher = patLowerCase.matcher(password)
        return matchLower.find() && matchUpper.find()
    }

    fun optionThreeForPassword(password: String): Boolean {
        val patNumber = Pattern.compile("[0-9]")
        val matchNumber: Matcher = patNumber.matcher(password)
        return matchNumber.find()
    }

    fun isValidEmail(email: String): Boolean {
        if (email != "") {
            //for mail
            val mailContainCars = !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            val checkMailNumbers = email.split("@")[0]
            val checkIfMailNumbers: Int? = checkMailNumbers.toIntOrNull()

            return when {
                mailContainCars -> {
                    false
                }
                email.length < 14 -> {
                    false
                }
                checkIfMailNumbers != null -> {
                    false
                }
                else -> {
                    true
                }
            }
        } else {
            return false
        }

    }

     fun validateMobile(mobile: String): Boolean {
        when (mobile.length) {
            11 -> {
                val emailSplit = mobile.split("")
                val mobileFirstThreeNumber: String = emailSplit[1] + emailSplit[2] + emailSplit[3]
                return mobileFirstThreeNumber == "010" || mobileFirstThreeNumber == "011" || mobileFirstThreeNumber == "012" || mobileFirstThreeNumber == "015"
            }
            10 -> {
                val emailSplit = mobile.split("")

                val mobileFirstThreeNumber: String = emailSplit[1] + emailSplit[2] + emailSplit[3]
                return (mobileFirstThreeNumber == "050" || mobileFirstThreeNumber == "053" || mobileFirstThreeNumber == "054" || mobileFirstThreeNumber == "055"
                        || mobileFirstThreeNumber == "056" || mobileFirstThreeNumber == "057" || mobileFirstThreeNumber == "058" || mobileFirstThreeNumber == "059")
            }
            else -> {
                return false
            }
        }
    }
}