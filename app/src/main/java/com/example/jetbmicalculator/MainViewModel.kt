package com.example.jetbmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.pow
import kotlin.math.roundToInt

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    var bmi by mutableStateOf(0f)

    fun calculateBMI() {
        val heightNumber = height.toFloatOrNull()?.div(100) ?: 0f
        val weightNumber = weight.toFloatOrNull() ?: 0f

        bmi = if (heightNumber > 0f && weightNumber > 0f) {
            (weightNumber / heightNumber.pow(2) * 10).roundToInt() / 10f
        } else 0f
    }
}