package com.louis.data.database

import com.louis.data.cache.Store
import com.louis.data.database.dao.CacheDramaDao
import com.louis.data.database.drama.model.CacheDrama
import com.louis.data.database.drama.model.Query
import com.louis.data.database.drama.model.Sort

class DramaDiskStore(private val cacheDramaDao: CacheDramaDao) : Store.DBStore<Int, CacheDrama, Sort, Query> {

    override suspend fun getAll(sortList: List<Sort>, queryList: List<Query>): List<CacheDrama> {
        return cacheDramaDao.getCacheDramas(sortList, queryList)
    }

    override suspend fun getAll(): List<CacheDrama> {
        return getAll(emptyList(), emptyList())
    }

    override suspend fun putSingular(value: CacheDrama) {
        cacheDramaDao.insert(value)
    }

    override suspend fun putAll(valueList: List<CacheDrama>) {
        cacheDramaDao.insertAll(valueList)
    }

    override suspend fun clear() {
        cacheDramaDao.deleteAll()
    }

    override suspend fun getSingular(key: Int): CacheDrama? {
        return cacheDramaDao.getCacheDramasByIds(key).first()
    }
}