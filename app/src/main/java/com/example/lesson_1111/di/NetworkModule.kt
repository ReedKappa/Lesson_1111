package com.example.lesson_1111.di

import com.example.lesson_1111.data.api.LampService
import com.example.lesson_1111.data.api.SampleService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideLampService() : LampService =
        Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
            .baseUrl("http://192.168.88.176:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LampService::class.java)

    @Provides
    fun provideSampleService() : SampleService =
        Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
            .baseUrl("http://192.168.88.176:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(SampleService::class.java)

}