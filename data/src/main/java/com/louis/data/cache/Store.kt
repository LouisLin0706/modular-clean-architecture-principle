package com.louis.data.cache

import com.louis.data.database.DbQuery
import com.louis.data.database.DbSort
import com.louis.data.database.drama.model.CacheDrama
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
    interface DBStore<Key, Value, Sort : DbSort, Query : DbQuery> :
        Store<Key, Value> {
        suspend fun getAll(sortList: List<Sort>, queryList: List<Query>): List<CacheDrama>
    }


}

interface Func1<T, R> : Function<R> {
    fun call(var1: T): R
}