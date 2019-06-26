package com.louis.data.cache

import io.reactivex.annotations.NonNull


interface Store<Key, Value> {

    suspend fun putSingular(@NonNull value: Value)

    suspend fun putAll(@NonNull valueList: List<Value>)

    suspend fun clear()

    @NonNull
    suspend fun getSingular(@NonNull key: Key): Value?

    @NonNull
    suspend fun getAll(): List<Value>

    /**
     * More descriptive interface for memory based stores.
     */
    interface MemoryStore<Key, Value> : Store<Key, Value>

    /**
     * More descriptive interface for disk based stores.
     */
    interface DiskStore<Key, Value> : Store<Key, Value>
}

interface Func1<T, R> : Function<R> {
    fun call(var1: T): R
}