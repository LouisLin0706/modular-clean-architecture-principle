package com.louis.core.di

import com.louis.core.presentation.dramas.DramasViewModel
import com.louis.data.network.drama.DramaApiClient
import com.louis.data.repository.DramaRepo
import com.louis.domain.interactor.drama.DramaInteractor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coreModel = module {
    factory { DramaApiClient() }
    factory { DramaRepo(get<DramaApiClient>()) }
    factory { DramaInteractor(get()) }
    viewModel { DramasViewModel(get()) }
}