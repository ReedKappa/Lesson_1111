package com.example.lesson_1111.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lesson_1111.presentation.LampViewModel
import com.example.lesson_1111.presentation.SampleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SampleViewModel::class)
    abstract fun bindSampleViewModel(viewModel: SampleViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LampViewModel::class)
    abstract fun bindLampViewModel(viewModel: LampViewModel) : ViewModel

}