package com.louis.domain.interactor.drama

import com.louis.data.database.ConditionOperation
import com.louis.data.database.Operation
import com.louis.data.database.drama.model.CacheDrama
import com.louis.data.database.drama.model.Query
import com.louis.data.database.drama.model.Sort
import com.louis.data.repository.DramaRepoProtocol

class DramaInteractor(private val dramaRepoProtocol: DramaRepoProtocol) : DramaInteractorPrtocol {

    override suspend fun getCacheDrama(keyWords: String): List<CacheDrama> {
        val query = Query(CacheDrama.DRAMA_NAME, Operation.LIKE, keyWords, ConditionOperation.NONE)
        return dramaRepoProtocol.getCacheDramas(listOf(createDefaultSort()), listOf(query))
    }

    override suspend fun fetchCacheDramas(): List<CacheDrama> {
        return dramaRepoProtocol.fetchDrama()
    }

    override suspend fun getCacheDrama(key: Int): CacheDrama? {
        return dramaRepoProtocol.getCacheDrama(key)
    }

    private fun createDefaultSort(): Sort {
        return Sort(CacheDrama.VIEW_COUNT, false)
    }
}