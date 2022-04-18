package com.gb.dictionary

import android.app.Application
import com.gb.dictionary.di.DI
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(DI.mineScreen, DI.app)
        }

    }
}