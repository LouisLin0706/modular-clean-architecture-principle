package com.louis.core.presentation.dramas

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import com.louis.core.arch.BaseViewModel
import com.louis.core.data.LoadingState
import com.louis.core.data.Resource
import com.louis.domain.interactor.drama.DramaInteractor
import com.louis.domain.model.Drama
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DramasViewModel(private val dramaInteractor: DramaInteractor) : BaseViewModel() {

    val dramas = MutableLiveData<Resource<List<Drama>>>()

    @SuppressLint("CheckResult")
    fun fetchDramas() {
        GlobalScope.launch(coroutineContext) {
            try {
                withContext(Dispatchers.Main) {
                    loadingState.value = LoadingState.show()
                }
                val data = dramaInteractor.get(Unit)
                dramas.postValue(Resource.success(data))
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                withContext(Dispatchers.Main) {
                    loadingState.value = LoadingState.hide()
                }
            }
        }
    }
}