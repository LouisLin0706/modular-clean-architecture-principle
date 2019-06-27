package com.louis.core.presentation.dramas

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import com.louis.core.arch.BaseViewModel
import com.louis.core.data.LoadingState
import com.louis.core.data.model.CoroutinesDispatcherProvider
import com.louis.domain.interactor.drama.DramaInteractorPrtocol
import com.louis.domain.model.Drama
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

    val dramas = MutableLiveData<List<Drama>>()
    val error = MutableLiveData<String>()

    @SuppressLint("CheckResult")
    fun fetchDramas()  {
        GlobalScope.launch(coroutineContext) {
            try {
                withContext(coroutinesDispatcherProvider.main) {
                    loadingState.value = LoadingState.show()
                }
                val data = dramaInteractor.getDramas()
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