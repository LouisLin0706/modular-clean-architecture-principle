package com.louis.data

import okhttp3.Request
import retrofit2.Call

abstract class MockCall<T> : Call<T> {

    override fun isExecuted(): Boolean {
        return false
    }

    override fun clone(): Call<T> {
        return this
    }

    override fun isCanceled(): Boolean {
        return false
    }

    override fun cancel() {

    }
    override fun request(): Request {
        return Request.Builder().build()
    }
}