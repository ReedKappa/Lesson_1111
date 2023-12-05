package com.example.lesson_1111.di

import com.example.lesson_1111.presentation.bulb.BulbFragment
import com.example.lesson_1111.presentation.lamp.LampFragment
import com.example.lesson_1111.presentation.sample.SampleFragment
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
    fun inject(fragment: BulbFragment)
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