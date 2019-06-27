package com.louis.core.arch

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.louis.core.data.LoadingState
import com.louis.core.data.model.CoroutinesDispatcherProvider
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Provide coroutines & rxjava cancel way
 */
open class BaseViewModel(private val coroutinesDispatcherProvider: CoroutinesDispatcherProvider) : ViewModel(),
    CoroutineScope {

    open val loadingState = MutableLiveData<LoadingState>()

    override val coroutineContext: CoroutineContext
        //Default work in io thread
        get() = job + coroutinesDispatcherProvider.io

    val disposables: CompositeDisposable = CompositeDisposable()
    private val job = Job()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
        job.cancel()
    }
}