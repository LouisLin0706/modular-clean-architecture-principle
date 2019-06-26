package com.louis.data.cache

data class CacheEntry<T>(val cachedObject: T, val creationTimestamp: Long)