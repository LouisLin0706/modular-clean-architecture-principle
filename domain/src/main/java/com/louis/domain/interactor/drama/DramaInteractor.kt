package com.louis.domain.interactor.drama

import com.louis.data.cache.Func1
import com.louis.data.repository.DramaRepoProtocol
import com.louis.domain.model.Drama

class DramaInteractor(private val dramaRepoProtocol: DramaRepoProtocol) : DramaInteractorPrtocol {
    override suspend fun getDrama(func1: Func1<String, Drama>): Drama {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getDramas(): List<Drama> {
        return dramaRepoProtocol.fetchDrama()
            .map {
                Drama(
                    dramaId = it.dramaId,
                    dramaName = it.dramaName,
                    createdAt = it.createdAt,
                    totalViews = it.totalViews,
                    thumbUrl = it.thumbUrl,
                    rating = it.rating
                )
            }.toList()
    }

}