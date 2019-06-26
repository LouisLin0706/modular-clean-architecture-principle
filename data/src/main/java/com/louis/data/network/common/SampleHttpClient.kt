package com.louis.data.network.common

import android.util.Log
import com.louis.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class SampleHttpClient {

    companion object {
        fun getStandardClient(): OkHttpClient {
            val builder = baseClient(true)
            //TODO SSL IF NECESSARY IN FEATURE
            return builder.build()
        }

        fun baseClient(
            shouldLogBody: Boolean,
            interceptors: List<Interceptor>? = null,
            networkInterceptors: List<Interceptor>? = null
        ): OkHttpClient.Builder {
            val builder = OkHttpClient.Builder()

            builder.connectTimeout(16, TimeUnit.SECONDS)

            interceptors?.forEach { builder.addInterceptor(it) }
            networkInterceptors?.forEach { builder.addNetworkInterceptor(it) }

            // Interceptors
            val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                if (BuildConfig.DEBUG) Log.i(SampleHttpClient::class.java.simpleName, message)
            })
            loggingInterceptor.level =
                if (shouldLogBody) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.HEADERS
            builder.addNetworkInterceptor(loggingInterceptor)

            // SSL verifier
            if (BuildConfig.DEBUG) {
                builder.hostnameVerifier { _, _ -> true }
            }
            return builder
        }


    }
}