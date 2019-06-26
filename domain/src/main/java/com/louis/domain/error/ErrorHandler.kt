package com.louis.domain.error


class ErrorHandler(private val exceptionTransformer: ExceptionTransformer = DefaultTransformer()) {
    fun handle(t: Throwable): AppException {
        return exceptionTransformer.transform(t)
    }
}
