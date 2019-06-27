package com.louis.feature_home

import com.louis.core.arch.BaseViewModel
import com.louis.core.data.model.CoroutinesDispatcherProvider
import kotlinx.coroutines.Dispatchers

class HomeViewModel(
    private val coroutinesDispatcherProvider: CoroutinesDispatcherProvider = CoroutinesDispatcherProvider(
        Dispatchers.Main,
        Dispatchers.Unconfined,
        Dispatchers.IO
    )
) : BaseViewModel(coroutinesDispatcherProvider) {
}