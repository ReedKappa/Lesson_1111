package com.example.lesson_1111.di

import com.example.lesson_1111.data.api.SampleService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideSampleService() : SampleService =
        Retrofit.Builder().
            baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(SampleService::class.java)

}