package com.example.lesson_1111.domain

import com.example.lesson_1111.data.repository.SampleRepository
import javax.inject.Inject

interface ChangeBrightnessUseCase {
    suspend operator fun invoke(brightnessValue: Int): Result<Boolean?>
}

class ChangeBrightnessUseCaseImpl @Inject constructor(
    private val repository: SampleRepository
) : ChangeBrightnessUseCase {
    override suspend fun invoke(brightnessValue: Int): Result<Boolean?> =
        repository.changeBrightness(brightnessValue)
}
