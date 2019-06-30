package com.louis.data.cache

import java.util.concurrent.ConcurrentHashMap

class Cache<Key, Value>(
    val extractKeyFromModel: Func1<Value, Key>
) : Store.MemoryStore<Key, Value> {
    override suspend fun getAll(): List<Value> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val cache: MutableMap<Key, CacheEntry<Value>> = ConcurrentHashMap()

    override suspend fun putAll(valueList: List<Value>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun clear() {
        cache.clear()
    }

    override suspend fun getSingular(key: Key): Value? {
        return cache[key]?.cachedObject
    }


    override suspend fun putSingular(value: Value) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}