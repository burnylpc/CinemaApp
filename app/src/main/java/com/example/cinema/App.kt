package com.example.cinema

import android.app.Application
import com.example.cinema.di.appModule
import com.example.cinema.features.movies_cards_screen.di.moviesListScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, moviesListScreenModule)
        }
    }
}