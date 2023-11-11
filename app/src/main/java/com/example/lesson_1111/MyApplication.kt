package com.example.lesson_1111

import android.app.Application
import android.content.Context
import com.example.lesson_1111.di.AppComponent
import com.example.lesson_1111.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}
