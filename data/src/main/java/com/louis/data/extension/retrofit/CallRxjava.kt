package com.louis.data.extension.retrofit

import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


fun <T : Any> Call<T>.toSingle(): Single<T> {
    return Single.create { emitter ->
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                try {
                    emitter.onSuccess(response.body()!!)
                } catch (e: Exception) {
                    emitter.onError(e)
                }
            }
            override fun onFailure(call: Call<T>, t: Throwable) {
                emitter.onError(t)
            }
        })
    }

}