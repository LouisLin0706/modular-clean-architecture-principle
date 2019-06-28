package com.louis.feature_home.di

import com.louis.feature_home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModel = module {
    viewModel { HomeViewModel() }
}