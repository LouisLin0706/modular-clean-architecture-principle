package com.louis.data.network.common.gson


import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.IOException

/**
 * 處理回傳的 JSON 有固定格式時，可以直接取出需要的資料。
 */

open class GsonTypeAdapterFactory(val dataKey: String) : TypeAdapterFactory {

    init {
        if (dataKey.isEmpty()) {
            throw IllegalArgumentException("JSON key cannot be empty")
        }
    }

    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T> {
        val delegate = gson.getDelegateAdapter(this, type)
        val elementAdapter = gson.getAdapter(JsonElement::class.java)

        return object : TypeAdapter<T>() {

            @Throws(IOException::class)
            override fun write(out: JsonWriter, value: T) {
                delegate.write(out, value)
            }

            @Throws(IOException::class)
            override fun read(input: JsonReader): T {

                var jsonElement = elementAdapter.read(input)
                if (jsonElement.isJsonObject) {
                    val jsonObject = jsonElement.asJsonObject
                    if (jsonObject.has(dataKey)) {
                        jsonElement = jsonObject.get(dataKey)
                    }
                }

                return delegate.fromJsonTree(jsonElement)
            }
        }.nullSafe()
    }
}