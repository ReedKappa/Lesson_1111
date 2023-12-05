package com.example.lesson_1111.data.repository

import com.example.lesson_1111.data.api.LampService
import com.example.lesson_1111.data.api.SampleService
import com.example.lesson_1111.data.module.CurrentColorModel
import com.example.lesson_1111.data.module.Joke
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

interface SampleRepository {
    suspend fun getJoke(): Result<Joke?>
    suspend fun getJokesCategories(): Result<List<String>?>
    suspend fun turnLampOn(): Result<Boolean?>
    suspend fun turnLampOff(): Result<Boolean?>
    suspend fun getColorNames(): Result<List<String>?>
    suspend fun setColor(colorName: String): Result<Boolean?>
    suspend fun changeBrightness(brightnessValue: Int): Result<Boolean?>
    suspend fun getBulbState(): Result<Boolean?>
    suspend fun getCurrentBrightnessLevel(): Result<Int?>
    suspend fun getCurrentColor(): Result<CurrentColorModel?>
}

class SampleRepositoryImpl @Inject constructor(
    private val service: SampleService,
    private val lampService: LampService
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

    override suspend fun turnLampOn(): Result<Boolean?> {
        runCatching {
            lampService.turnLampOn()
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun turnLampOff(): Result<Boolean?> {
        runCatching {
            lampService.turnLampOff()
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getColorNames(): Result<List<String>?> =
        convertToResult {
            lampService.getColorNames()
        }


    override suspend fun setColor(colorName: String): Result<Boolean?> {
        runCatching {
            lampService.setColor(colorName)
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun changeBrightness(brightnessValue: Int): Result<Boolean?> {
        runCatching {
            lampService.changeBrightness(brightnessValue)
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getBulbState(): Result<Boolean?> {
        kotlin.runCatching {
            lampService.getBulbState()
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getCurrentBrightnessLevel(): Result<Int?> =
        convertToResult {
            lampService.getCurrentBrightnessLevel()
        }

    override suspend fun getCurrentColor(): Result<CurrentColorModel?> =
        convertToResult {
            lampService.getCurrentColor()
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