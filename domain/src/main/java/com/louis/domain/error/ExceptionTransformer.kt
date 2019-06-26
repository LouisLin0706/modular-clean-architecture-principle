package com.louis.domain.error


interface ExceptionTransformer {
    fun transform(t: Throwable): AppException
}
