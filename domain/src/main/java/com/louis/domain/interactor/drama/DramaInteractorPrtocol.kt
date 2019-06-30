package com.louis.domain.interactor.drama

import com.louis.data.database.drama.model.CacheDrama

interface DramaInteractorPrtocol {

    suspend fun fetchCacheDramas(): List<CacheDrama>

    suspend fun getCacheDrama(key: Int): CacheDrama?

    suspend fun getCacheDrama(keyWords: String): List<CacheDrama>
}