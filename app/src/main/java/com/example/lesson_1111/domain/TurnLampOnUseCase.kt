package com.example.lesson_1111.domain

import com.example.lesson_1111.data.repository.SampleRepository
import javax.inject.Inject

interface TurnLampOnUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}

class TurnLampOnUseCaseImpl @Inject constructor(
    private val repository: SampleRepository
) : TurnLampOnUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.turnLampOn()

}