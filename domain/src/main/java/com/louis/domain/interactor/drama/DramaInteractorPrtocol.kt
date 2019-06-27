package com.louis.domain.interactor.drama

import com.louis.domain.model.Drama

interface DramaInteractorPrtocol {
    suspend fun getDramas(): List<Drama>
}