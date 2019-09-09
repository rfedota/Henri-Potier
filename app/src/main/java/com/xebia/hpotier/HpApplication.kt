package com.xebia.hpotier

import android.app.Application
import com.xebia.hpotier.di.*
import org.koin.android.ext.android.startKoin

@Suppress("Unused")
class HpApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //add module to inject
        startKoin(this, listOf(
            networkModule,
            apiModule,
            viewModelModule,
            roomModule
        ))
    }
}
