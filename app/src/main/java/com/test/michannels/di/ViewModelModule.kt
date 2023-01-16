package com.test.michannels.di

import com.test.michannels.presentation.MainViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {

    viewModel {
        MainViewModel()
    }
}