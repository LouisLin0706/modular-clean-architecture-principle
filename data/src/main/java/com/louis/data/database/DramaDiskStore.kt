package com.louis.data.database

import com.louis.data.cache.Store
import com.louis.data.database.drama.model.CacheDrama

class DramaDiskStore() : Store.DiskStore<Int, CacheDrama> {

    override suspend fun putSingular(value: CacheDrama) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun putAll(valueList: List<CacheDrama>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getSingular(key: Int): CacheDrama? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getAll(): List<CacheDrama> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}