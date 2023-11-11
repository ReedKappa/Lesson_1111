package com.example.lesson_1111.di

import android.content.Context
import com.example.lesson_1111.MyApplication

val Context.appComponent: AppComponent
    get() = when (this) {
        is MyApplication -> appComponent
        else -> applicationContext.appComponent
    }