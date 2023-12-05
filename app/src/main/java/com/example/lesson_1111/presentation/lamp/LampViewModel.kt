package com.example.lesson_1111.presentation.lamp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson_1111.UiState
import com.example.lesson_1111.domain.ChangeBrightnessUseCase
import com.example.lesson_1111.domain.GetColorNamesUseCase
import com.example.lesson_1111.domain.SetColorUseCase
import com.example.lesson_1111.domain.TurnLampOffUseCase
import com.example.lesson_1111.domain.TurnLampOnUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class LampViewModel @Inject constructor(
    private val turnLampOnUseCase: TurnLampOnUseCase,
    private val turnLampOffUseCase: TurnLampOffUseCase,
    private val getColorNamesUseCase: GetColorNamesUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val changeBrightnessUseCase: ChangeBrightnessUseCase
): ViewModel() {

    private val _colorNames = MutableLiveData<UiState<List<String>>>()
    val colorNames: LiveData<UiState<List<String>>>
        get() =
            _colorNames


    fun getColorsNames() {
        viewModelScope.launch {
            val colorNamesResult = getColorNamesUseCase()
            if (colorNamesResult.isSuccess) {
                val colors = colorNamesResult.getOrNull()
                colors ?: _colorNames.postValue(UiState.Failure("Data was null!"))
                _colorNames.postValue(colors?.let { UiState.Success(it) } ?: UiState.Failure("Data was null!"))
            } else _colorNames.postValue(
                UiState.Failure(colorNamesResult.exceptionOrNull()?.message ?: "Very weird problems")
            )
        }
    }

    fun changeColor(colorName: String) {
        viewModelScope.launch {
            setColorUseCase(colorName)
        }
    }


    fun turnLampOn() {
        viewModelScope.launch {
            turnLampOnUseCase()
        }
    }

    fun turnLampOff() {
        viewModelScope.launch {
            turnLampOffUseCase()
        }
    }

    fun changeBrightness(brightnessValue: Int) {
        viewModelScope.launch {
            changeBrightnessUseCase(brightnessValue)
        }
    }
}