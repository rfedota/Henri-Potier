package com.xebia.hpotier.di

import com.xebia.hpotier.data.room.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val roomModule = module {
    single { AppDatabase.getInstance(androidApplication()) }
    single(createOnStart = false) { get<AppDatabase>().getCartBookDao() }
}