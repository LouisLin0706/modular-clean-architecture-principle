package com.louis.domain.interactor

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.annotations.NonNull


interface ReactiveInteractor {

    interface RetrieveInteractor<Params, Object> : ReactiveInteractor {

        @NonNull
        fun getBehaviorStream(@NonNull params: Params): Observable<Object>
    }


    interface RequestInteractor<Params, Result> : ReactiveInteractor {

        @NonNull
        fun getSingle(@NonNull params: Params): Single<Result>
    }

    interface RefreshInteractor<Params> : ReactiveInteractor {

        @NonNull
        fun getRefreshSingle(@NonNull params: Params): Completable
    }
}