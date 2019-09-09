package com.xebia.hpotier.di

import com.xebia.hpotier.data.remote.api.HpotierApi
import org.koin.dsl.module.module
import retrofit2.Retrofit

val apiModule = module {
    single(createOnStart = false) { get<Retrofit>().create(HpotierApi::class.java) }
}