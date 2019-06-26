package com.louis.domain.error

import com.louis.domain.R
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class DefaultTransformer : ExceptionTransformer {
    override fun transform(t: Throwable): AppException {
        return when (t) {
            is HttpException -> {
                AppException(R.string.error_network, t)
            }
            is NullPointerException -> {
                AppException(R.string.error_other, t)
            }
            is ConnectException, is SocketTimeoutException, is UnknownHostException -> {
                AppException(R.string.error_connect, t)
            }
            else -> {
                AppException(R.string.error_other, t)
            }
        }
    }

}