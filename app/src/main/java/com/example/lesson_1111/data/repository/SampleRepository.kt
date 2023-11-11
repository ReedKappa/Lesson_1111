package com.example.lesson_1111.data.repository

import com.example.lesson_1111.data.api.SampleService
import com.example.lesson_1111.data.module.Joke
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

interface SampleRepository {
    suspend fun getJoke(): Result<Joke?>
    suspend fun getJokesCategories(): Result<List<String>?>
}

class SampleRepositoryImpl @Inject constructor(
    private val service: SampleService
) : SampleRepository {
    //Можно так
    override suspend fun getJoke(): Result<Joke?> {
        runCatching {
            service.getRandomJoke()
        }.fold(
            onSuccess = {
                if (it.isSuccessful)
                    return Result.success(it.body())
                else
                    return Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }
    //или так
    override suspend fun getJokesCategories(): Result<List<String>?> =
        convertToResult {
            service.getJokesCategories()
        }


}

suspend fun <T> convertToResult(func: suspend () -> Response<T>): Result<T?> {
    runCatching {
        func()
    }.fold(
        onSuccess = {
            if (it.isSuccessful)
                return Result.success(it.body())
            else
                return Result.failure(HttpException(it))
        },
        onFailure = {
            return Result.failure(it)
        }
    )
}