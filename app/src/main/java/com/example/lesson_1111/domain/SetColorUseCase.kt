package com.example.lesson_1111.domain

import com.example.lesson_1111.data.repository.SampleRepository
import javax.inject.Inject

interface SetColorUseCase {
    suspend operator fun invoke(colorNAme: String): Result<Boolean?>
}

class SetColorUseCaseImpl @Inject constructor(
    private val repository: SampleRepository
): SetColorUseCase {
    override suspend fun invoke(colorName: String): Result<Boolean?> =
        repository.setColor(colorName)
}