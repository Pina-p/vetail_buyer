package com.example.myapplication.vetaillayout.utils

import java.util.regex.Pattern

object PasswordPatterns {
    val passwordOneAlpha: Pattern = Pattern.compile("^(?=.*[a-zA-Z])$")
    val passwordSixDigit: Pattern = Pattern.compile("^.{6,}$")
    val passwordOneNum: Pattern = Pattern.compile("^(?=.*[0-9])$")
}