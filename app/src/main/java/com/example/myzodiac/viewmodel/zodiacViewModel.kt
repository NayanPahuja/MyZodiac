package com.example.myzodiac.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myzodiac.model.ZodiacRepository
import com.example.myzodiac.model.ZodiacSign
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

// ZodiacViewModel.kt
open class ZodiacViewModel(
    private val repository: ZodiacRepository = ZodiacRepository()
) : ViewModel() {
    private val _zodiacSign = MutableStateFlow<ZodiacSign?>(null)
    open val zodiacSign = _zodiacSign.asStateFlow()

    @SuppressLint("NewApi")
    fun calculateZodiacSign(birthDate: LocalDate) {
        viewModelScope.launch {
            _zodiacSign.value = repository.getZodiacSign(
                month = birthDate.monthValue,
                day = birthDate.dayOfMonth
            )
        }
    }
}