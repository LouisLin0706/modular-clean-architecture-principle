package com.louis.core.presentation.dramas

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.louis.core.arch.BaseViewModel
import com.louis.core.data.LoadingState
import com.louis.core.data.model.CoroutinesDispatcherProvider
import com.louis.data.database.drama.model.CacheDrama
import com.louis.domain.interactor.drama.DramaInteractorPrtocol
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DramasViewModel(
    private val dramaInteractor: DramaInteractorPrtocol,
    private val coroutinesDispatcherProvider: CoroutinesDispatcherProvider = CoroutinesDispatcherProvider(
        Dispatchers.Main,
        Dispatchers.Unconfined,
        Dispatchers.IO
    )
) : BaseViewModel(coroutinesDispatcherProvider) {

    val dramas = MutableLiveData<List<CacheDrama>>()
    val error = MutableLiveData<String>()

    @SuppressLint("CheckResult")
    fun fetchDramas() {
        GlobalScope.launch(coroutineContext) {
            try {
                withContext(coroutinesDispatcherProvider.main) {
                    loadingState.value = LoadingState.show()
                }
                val data = dramaInteractor.fetchCacheDramas()
                dramas.postValue(data)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                withContext(coroutinesDispatcherProvider.main) {
                    loadingState.value = LoadingState.hide()
                }
            }
        }
    }


    fun refresh() {
        fetchDramas()
    }
}