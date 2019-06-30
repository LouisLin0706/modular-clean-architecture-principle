package com.louis.data.repository

import com.louis.data.database.drama.model.CacheDrama
import com.louis.data.database.drama.model.Query
import com.louis.data.database.drama.model.Sort

interface DramaRepoProtocol {
    suspend fun fetchDrama(): List<CacheDrama>
    suspend fun getCacheDramas(): List<CacheDrama>
    suspend fun getCacheDrama(dramaId: Int): CacheDrama?
    suspend fun getCacheDramas(sort: List<Sort>, query: List<Query>): List<CacheDrama>
}