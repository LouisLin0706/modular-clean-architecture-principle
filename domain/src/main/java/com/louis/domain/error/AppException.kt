package com.louis.domain.error

class AppException(val errorMessage: Int, original: Throwable? = null) : Throwable(cause = original) {

}