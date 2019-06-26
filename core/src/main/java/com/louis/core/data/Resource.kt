package com.louis.core.data

import com.louis.domain.error.AppException

class Resource<T> private constructor(val status: Resource.Status, val data: T?, val exception: AppException?) {
    enum class Status {
        SUCCESS, ERROR
    }

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(exception: AppException?): Resource<T> {
            return Resource(Status.ERROR, null, exception)
        }
    }
}

class LoadingState private constructor(val status: LoadingState.Status) {
    enum class Status {
        SHOW, HIDE
    }

    companion object {

        fun hide(): LoadingState {
            return LoadingState(LoadingState.Status.HIDE)
        }

        fun show(): LoadingState {
            return LoadingState(LoadingState.Status.SHOW)
        }
    }
}