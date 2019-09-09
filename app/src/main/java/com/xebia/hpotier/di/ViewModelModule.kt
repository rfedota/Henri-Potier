package com.xebia.hpotier.di

import com.xebia.hpotier.ui.books.BookesViewModel
import com.xebia.hpotier.ui.cart.CartViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { BookesViewModel(androidContext(), get(), get()) }
    viewModel { CartViewModel(androidContext(), get(), get()) }
}