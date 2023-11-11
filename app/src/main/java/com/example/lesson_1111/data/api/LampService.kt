package com.example.lesson_1111.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LampService {
    @POST("state/on")
    suspend fun turnLampOn(): Response<Boolean>

    @POST("state/off")
    suspend fun turnLampOff(): Response<Boolean>

    @GET("color/names_only")
    suspend fun getColorNames(): Response<List<String>>

    @POST("color/")
    suspend fun setColor(@Query("color") colorName: String): Response<Boolean>

}