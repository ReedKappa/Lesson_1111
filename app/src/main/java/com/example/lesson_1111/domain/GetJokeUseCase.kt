package com.example.lesson_1111.domain

import com.example.lesson_1111.data.module.Joke
import com.example.lesson_1111.data.repository.SampleRepository
import javax.inject.Inject

interface GetJokeUseCase {
    suspend operator fun invoke(): Result<Joke?>
}

class GetJokeUseCaseImpl @Inject constructor(
    private val repository: SampleRepository,
) : GetJokeUseCase {
    override suspend fun invoke(): Result<Joke?> =
        repository.getJoke()

}
