package com.louis.data.network.common.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder

class SampleApiGson {

    companion object {

        fun createDefaultAPIGson(): Gson {
            return baseGsonBuilder().create()
        }

        fun createStandardAPIGson(): Gson {
            val builder = baseGsonBuilder()
            builder.registerTypeAdapterFactory(StandardAPITypeAdapterFactory())
            return builder.create()
        }


        private fun baseGsonBuilder(): GsonBuilder {
            return GsonBuilder()
                .setLenient()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.sssZ")
        }
    }
}