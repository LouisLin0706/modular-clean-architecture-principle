package com.louis.domain.interactor

import io.reactivex.annotations.NonNull


interface CoroutinesInteractor {

    interface RequestInteractor<Params, Result> : CoroutinesInteractor {

        @NonNull
        suspend fun get(@NonNull params: Params): Result
    }
}