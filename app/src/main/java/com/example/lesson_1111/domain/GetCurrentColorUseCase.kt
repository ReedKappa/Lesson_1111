package com.example.lesson_1111.domain

import com.example.lesson_1111.data.module.CurrentColorModel
import com.example.lesson_1111.data.repository.SampleRepository
import javax.inject.Inject

interface GetCurrentColorUseCase {
    suspend operator fun invoke(): Result<CurrentColorModel?>
}

class GetCurrentColorUseCaseImpl @Inject constructor(
    private val repository: SampleRepository
): GetCurrentColorUseCase {
    override suspend fun invoke(): Result<CurrentColorModel?> =
        repository.getCurrentColor()

}