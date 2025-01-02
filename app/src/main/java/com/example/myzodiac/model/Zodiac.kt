package com.example.myzodiac.model

data class ZodiacSign(
    val name: String,
    val startDate: Pair<Int, Int>, // Month, Day
    val endDate: Pair<Int, Int>,   // Month, Day
    val description: String,
    val history: String,
    val iconResId: Int,
    val imageResId: Int
)