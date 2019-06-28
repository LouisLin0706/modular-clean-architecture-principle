package com.louis.core.di

import com.louis.core.presentation.dramas.DramasViewModel
import com.louis.data.database.DramaDiskStore
import com.louis.data.network.drama.DramaApiClient
import com.louis.data.repository.DramaRepo
import com.louis.domain.interactor.drama.DramaInteractor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coreModel = module {
    factory { DramaApiClient() }
    factory { DramaDiskStore() }
    factory { DramaRepo(get<DramaApiClient>(), get<DramaDiskStore>()) }
    factory { DramaInteractor(get<DramaRepo>()) }
    viewModel { DramasViewModel(get<DramaInteractor>()) }
}