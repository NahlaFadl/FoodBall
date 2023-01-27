package com.example.testfoodball

import android.app.Application
import com.example.testfoodball.di_module.appModule
import com.example.testfoodball.di_module.repostoryModule
import com.example.testfoodball.di_module.viewModleModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repostoryModule, viewModleModule))
        }
    }

}