package com.xebia.hpotier

import android.app.Application
import com.xebia.hpotier.di.apiModule
import com.xebia.hpotier.di.networkModule
import com.xebia.hpotier.di.roomModule
import com.xebia.hpotier.di.viewModelModule
import org.koin.android.ext.android.startKoin

@Suppress("Unused")
class HpApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // add module to inject
        startKoin(this, listOf(
            networkModule,
            apiModule,
            viewModelModule,
            roomModule
        ))
    }
}
