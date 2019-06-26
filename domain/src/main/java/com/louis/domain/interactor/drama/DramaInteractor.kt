package com.louis.domain.interactor.drama

import com.louis.data.repository.DramaRepo
import com.louis.domain.interactor.CoroutinesInteractor
import com.louis.domain.model.Drama

class DramaInteractor(private val dramaRepo: DramaRepo) : CoroutinesInteractor.RequestInteractor<Unit, List<Drama>> {

    override suspend fun get(params: Unit): List<Drama> {
        return dramaRepo.fetchDramaDraftRawList()
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