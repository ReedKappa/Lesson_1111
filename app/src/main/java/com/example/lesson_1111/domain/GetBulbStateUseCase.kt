package com.example.lesson_1111.domain

import com.example.lesson_1111.data.repository.SampleRepository
import javax.inject.Inject

interface GetBulbStateUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}

class GetBulbStateUseCaseImpl @Inject constructor(
    private val repository: SampleRepository
) : GetBulbStateUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.getBulbState()

}