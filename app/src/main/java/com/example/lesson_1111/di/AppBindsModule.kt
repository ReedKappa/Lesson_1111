package com.example.lesson_1111.di

import com.example.lesson_1111.data.repository.SampleRepository
import com.example.lesson_1111.data.repository.SampleRepositoryImpl
import com.example.lesson_1111.domain.ChangeBrightnessUseCase
import com.example.lesson_1111.domain.ChangeBrightnessUseCaseImpl
import com.example.lesson_1111.domain.GetBulbStateUseCase
import com.example.lesson_1111.domain.GetBulbStateUseCaseImpl
import com.example.lesson_1111.domain.GetColorNamesUseCase
import com.example.lesson_1111.domain.GetColorNamesUseCaseImpl
import com.example.lesson_1111.domain.GetCurrentBrightnessLevelUseCase
import com.example.lesson_1111.domain.GetCurrentBrightnessLevelUseCaseImpl
import com.example.lesson_1111.domain.GetCurrentColorUseCase
import com.example.lesson_1111.domain.GetCurrentColorUseCaseImpl
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

    @Binds
    fun bindChangeBrightnessUseCase(useCase: ChangeBrightnessUseCaseImpl): ChangeBrightnessUseCase
    @Binds
    fun  bindGetBulbStateUseCase(useCase: GetBulbStateUseCaseImpl): GetBulbStateUseCase
    @Binds
    fun bindGetCurrentBrightnessLevelUseCase(useCase: GetCurrentBrightnessLevelUseCaseImpl): GetCurrentBrightnessLevelUseCase
    @Binds
    fun bindGetCurrentColorUseCase(useCase: GetCurrentColorUseCaseImpl): GetCurrentColorUseCase
}