package com.example.lesson_1111.domain

import com.example.lesson_1111.data.repository.SampleRepository
import javax.inject.Inject

interface TurnLampOffUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}

class TurnLampOffUseCaseImpl @Inject constructor(
    private val repository: SampleRepository
): TurnLampOffUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.turnLampOff()
}