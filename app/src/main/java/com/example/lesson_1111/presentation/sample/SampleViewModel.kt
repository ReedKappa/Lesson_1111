package com.example.lesson_1111.presentation.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson_1111.UiState
import com.example.lesson_1111.domain.GetJokesCategoriesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SampleViewModel @Inject constructor(
    private val getJokesCategoriesUseCase: GetJokesCategoriesUseCase
): ViewModel() {

    private val _jokesCategories = MutableLiveData<UiState<List<String>>>(UiState.Loading)
    val jokesCategories: LiveData<UiState<List<String>>>
        get() =
            _jokesCategories

    fun getJokesCategories() {
        viewModelScope.launch {
            val categoriesResult = getJokesCategoriesUseCase()
            if (categoriesResult.isSuccess) {
                val categories = categoriesResult.getOrNull()
                categories ?: _jokesCategories.postValue(UiState.Failure("Data was null!"))
                _jokesCategories.postValue(categories?.let { UiState.Success(it) } ?: UiState.Failure("Data was null!"))
            } else _jokesCategories.postValue(
                UiState.Failure(categoriesResult.exceptionOrNull()?.message ?: "Very weird problems")
            )
        }
    }
}