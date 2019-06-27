package com.louis.domain.interactor.drama

import com.louis.data.repository.DramaRepoProtocol
import com.louis.domain.model.Drama

class DramaInteractor(private val dramaRepoProtocol: DramaRepoProtocol) : DramaInteractorPrtocol {
    override suspend fun getDramas(): List<Drama> {
        return dramaRepoProtocol.fetchDramaDraftRawList()
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