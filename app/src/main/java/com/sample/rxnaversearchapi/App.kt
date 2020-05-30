package com.sample.rxnaversearchapi

import android.app.Application
import android.content.Context
import com.sample.rxnaversearchapi.data.di.repositoryModule
import com.sample.rxnaversearchapi.data.di.sourceModule
import com.sample.rxnaversearchapi.network.di.networkModule
import com.sample.rxnaversearchapi.viewmodel.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKOIN()
    }

    private fun startKOIN() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    repositoryModule,
                    sourceModule,
                    networkModule,
                    viewModelModule
                )
            )
        }
    }

    fun context(): Context = applicationContext

    companion object {
        lateinit var instance: App
            private set
    }
}