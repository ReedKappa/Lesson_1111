package com.example.lesson_1111.data.api

import com.example.lesson_1111.data.module.CurrentColorModel
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

    @POST("brightness/")
    suspend fun changeBrightness(@Query("level") brightnessValue: Int): Response<Boolean>

    @GET("state/")
    suspend fun getBulbState(): Response<Boolean>

    @GET("brightness/current")
    suspend fun getCurrentBrightnessLevel(): Response<Int>

    @GET("color/current")
    suspend fun getCurrentColor(): Response<CurrentColorModel>

}