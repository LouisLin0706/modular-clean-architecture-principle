package com.louis.domain.interactor.drama

import com.louis.data.cache.Func1
import com.louis.domain.model.Drama

interface DramaInteractorPrtocol {
    suspend fun getDramas(): List<Drama>
    suspend fun getDrama(func1: Func1<String, Drama>): Drama
}