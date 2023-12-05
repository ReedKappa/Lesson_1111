package com.example.lesson_1111.domain

import com.example.lesson_1111.data.repository.SampleRepository
import javax.inject.Inject

interface GetCurrentBrightnessLevelUseCase {
    suspend operator fun invoke(): Result<Int?>
}

class GetCurrentBrightnessLevelUseCaseImpl @Inject constructor(
    private val repository: SampleRepository
): GetCurrentBrightnessLevelUseCase {
    override suspend fun invoke(): Result<Int?> =
        repository.getCurrentBrightnessLevel()

}