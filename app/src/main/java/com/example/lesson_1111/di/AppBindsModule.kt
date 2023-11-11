package com.example.lesson_1111.di

import com.example.lesson_1111.data.repository.SampleRepository
import com.example.lesson_1111.data.repository.SampleRepositoryImpl
import com.example.lesson_1111.domain.GetJokeUseCase
import com.example.lesson_1111.domain.GetJokeUseCaseImpl
import com.example.lesson_1111.domain.GetJokesCategoriesUseCase
import com.example.lesson_1111.domain.GetJokesCategoriesUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {

    @Binds
    fun bindSampleRepository(repositoryImpl: SampleRepositoryImpl) : SampleRepository

    @Binds
    fun bindGetJokesCategoriesUseCase(useCase: GetJokesCategoriesUseCaseImpl): GetJokesCategoriesUseCase

    @Binds
    fun bindGetJokesUseCase(useCaseImpl: GetJokeUseCaseImpl): GetJokeUseCase
}