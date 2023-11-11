package com.example.lesson_1111.di

import com.example.lesson_1111.presentation.LampFragment
import com.example.lesson_1111.presentation.SampleFragment
import dagger.Component
import dagger.Module

@Component(
    modules = [
        AppModule::class,
    ]
)
interface AppComponent {
    fun inject(fragment: LampFragment)
    fun inject(fragment: SampleFragment)
}


@Module(
    includes = [
        NetworkModule::class,
        ViewModelModule::class,
        AppBindsModule::class
    ]
)
class AppModule {

}