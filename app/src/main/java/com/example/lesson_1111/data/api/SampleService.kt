package com.example.lesson_1111.data.api

import com.example.lesson_1111.data.module.Joke
import retrofit2.Response
import retrofit2.http.GET

interface SampleService {

    @GET("jokes/random")
    suspend fun getRandomJoke() : Response<Joke>

    @GET("jokes/categories")
    suspend fun getJokesCategories() : Response<List<String>>

}