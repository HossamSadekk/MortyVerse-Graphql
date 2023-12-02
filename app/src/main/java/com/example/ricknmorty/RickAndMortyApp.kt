package com.example.ricknmorty

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.presentation.di.presentationModule
import com.example.ricknmorty.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class RickAndMortyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin  {
            androidContext(this@RickAndMortyApp)
            androidLogger()
            modules(listOf(presentationModule, domainModule , dataModule))
        }
    }
}