package com.gb.dictionary

import android.app.Application
import com.gb.dictionary.di.component.DaggerComponent

class App : Application() {

    val appComponent by lazy {
        DaggerComponent.builder()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    companion object {

        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}