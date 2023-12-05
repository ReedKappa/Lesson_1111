package com.example.lesson_1111.presentation.bulb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson_1111.UiState
import com.example.lesson_1111.data.module.CurrentColorModel
import com.example.lesson_1111.domain.ChangeBrightnessUseCase
import com.example.lesson_1111.domain.GetBulbStateUseCase
import com.example.lesson_1111.domain.GetColorNamesUseCase
import com.example.lesson_1111.domain.GetCurrentBrightnessLevelUseCase
import com.example.lesson_1111.domain.GetCurrentColorUseCase
import com.example.lesson_1111.domain.SetColorUseCase
import com.example.lesson_1111.domain.TurnLampOffUseCase
import com.example.lesson_1111.domain.TurnLampOnUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class BulbViewModel @Inject constructor(
    private val turnLampOnUseCase: TurnLampOnUseCase,
    private val turnLampOffUseCase: TurnLampOffUseCase,
    private val getColorNamesUseCase: GetColorNamesUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val changeBrightnessUseCase: ChangeBrightnessUseCase,
    private val getBulbStateUseCase: GetBulbStateUseCase,
    private val getCurrentBrightnessLevelUseCase: GetCurrentBrightnessLevelUseCase,
    private val getCurrentColorUseCase: GetCurrentColorUseCase
) : ViewModel() {
    private val _colorNames = MutableLiveData<UiState<List<String>>>()
    val colorNames: LiveData<UiState<List<String>>>
        get() = _colorNames

    private val _currentColor = MutableLiveData<UiState<CurrentColorModel>>()
    val currentColor: LiveData<UiState<CurrentColorModel>>
        get() = _currentColor

    private val _bulbState = MutableLiveData<UiState<Boolean>>()
    val bulbState: LiveData<UiState<Boolean>>
        get() = _bulbState

    private val _currentBrightnessLevel = MutableLiveData<UiState<Int>>()
    val currentBrightnessLevel: LiveData<UiState<Int>>
        get() = _currentBrightnessLevel



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

    fun getBulbState() {
        viewModelScope.launch {
            val bulbStateResult = getBulbStateUseCase()
            if (bulbStateResult.isSuccess) {
                val state = bulbStateResult.getOrNull()
                state ?: _bulbState.postValue(UiState.Failure("Data was null"))
                _bulbState.postValue(state?.let { UiState.Success(it) } ?: UiState.Failure("Data was null"))
            } else {
                UiState.Failure(bulbStateResult.exceptionOrNull()?.message ?: "Very weird problems")
            }
        }
    }

    fun getCurrentBrightnessLevel() {
        viewModelScope.launch {
            val brightnessLevelResult = getCurrentBrightnessLevelUseCase()
            if (brightnessLevelResult.isSuccess) {
                val brightnessLevel = brightnessLevelResult.getOrNull()
                brightnessLevel ?: _currentBrightnessLevel.postValue(UiState.Failure("Data was null"))
                _currentBrightnessLevel.postValue(brightnessLevel?.let { UiState.Success(it) } ?: UiState.Failure("Data was null"))
            } else {
                UiState.Failure(brightnessLevelResult.exceptionOrNull()?.message ?: "Very weird problems")
            }
        }
    }

    fun getCurrentColor() {
        viewModelScope.launch {
            val currentColorResult = getCurrentColorUseCase()
            if (currentColorResult.isSuccess) {
                val currentColor = currentColorResult.getOrNull()
                currentColor ?: _currentColor.postValue(UiState.Failure("Data was null"))
                _currentColor.postValue(currentColor?.let { UiState.Success(it) } ?: UiState.Failure("Data was null"))
            } else {
                UiState.Failure(currentColorResult.exceptionOrNull()?.message ?: "Very weird problems")
            }
        }
    }
}