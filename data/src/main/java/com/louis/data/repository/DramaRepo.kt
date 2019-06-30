package com.louis.data.repository

import com.louis.data.cache.Store
import com.louis.data.database.drama.model.CacheDrama
import com.louis.data.database.drama.model.Query
import com.louis.data.database.drama.model.Sort
import com.louis.data.extension.retrofit.await
import com.louis.data.network.drama.DramaApiClientSpec

open class DramaRepo(
    private val dramaApiClient: DramaApiClientSpec,
    private val store: Store.DBStore<Int, CacheDrama, Sort, Query>
) : DramaRepoProtocol {
    override suspend fun getCacheDrama(dramaId: Int): CacheDrama? {
        return store.getSingular(dramaId)
    }

    override suspend fun getCacheDramas(sort: List<Sort>, query: List<Query>): List<CacheDrama> {
        return store.getAll(sort, query)
    }

    override suspend fun fetchDrama(): List<CacheDrama> {
        val data = dramaApiClient.fetchDramas().await()
        val transformToCaches = data.map {
            CacheDrama(
                dramaId = it.dramaId,
                dramaName = it.dramaName,
                totalViews = it.totalViews,
                createdAt = it.createdAt.time,
                thumbUrl = it.thumbUrl,
                rating = it.rating
            )
        }.toList()
        store.putAll(transformToCaches)
        return getCacheDramas()
    }

    override suspend fun getCacheDramas(): List<CacheDrama> {
        return getCacheDramas(query = emptyList(), sort = listOf(Sort(CacheDrama.RATING_COUNT)))
    }
}