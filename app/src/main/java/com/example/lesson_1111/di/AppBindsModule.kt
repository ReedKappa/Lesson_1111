package com.example.lesson_1111.di

import com.example.lesson_1111.data.repository.SampleRepository
import com.example.lesson_1111.data.repository.SampleRepositoryImpl
import com.example.lesson_1111.domain.GetColorNamesUseCase
import com.example.lesson_1111.domain.GetColorNamesUseCaseImpl
import com.example.lesson_1111.domain.GetJokeUseCase
import com.example.lesson_1111.domain.GetJokeUseCaseImpl
import com.example.lesson_1111.domain.GetJokesCategoriesUseCase
import com.example.lesson_1111.domain.GetJokesCategoriesUseCaseImpl
import com.example.lesson_1111.domain.SetColorUseCase
import com.example.lesson_1111.domain.SetColorUseCaseImpl
import com.example.lesson_1111.domain.TurnLampOffUseCase
import com.example.lesson_1111.domain.TurnLampOffUseCaseImpl
import com.example.lesson_1111.domain.TurnLampOnUseCase
import com.example.lesson_1111.domain.TurnLampOnUseCaseImpl
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

    @Binds
    fun bindTurnLampOnUseCase(useCase: TurnLampOnUseCaseImpl): TurnLampOnUseCase

    @Binds
    fun bindTurnLampOffUseCase(useCase: TurnLampOffUseCaseImpl): TurnLampOffUseCase

    @Binds
    fun bindSetColorUseCase(useCase: SetColorUseCaseImpl): SetColorUseCase

    @Binds
    fun bindGetColorNamesUseCase(useCase: GetColorNamesUseCaseImpl): GetColorNamesUseCase
}