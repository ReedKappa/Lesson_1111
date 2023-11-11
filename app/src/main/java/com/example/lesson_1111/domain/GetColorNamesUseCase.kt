package com.example.lesson_1111.domain

import com.example.lesson_1111.data.repository.SampleRepository
import javax.inject.Inject

interface GetColorNamesUseCase {
    suspend operator fun invoke(): Result<List<String>?>
}

class GetColorNamesUseCaseImpl @Inject constructor(
    private val repository: SampleRepository
): GetColorNamesUseCase {
    override suspend fun invoke(): Result<List<String>?> =
        repository.getColorNames()

}