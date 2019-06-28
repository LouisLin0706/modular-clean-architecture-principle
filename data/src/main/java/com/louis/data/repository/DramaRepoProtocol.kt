package com.louis.data.repository

import com.louis.data.cache.Func1
import com.louis.data.database.drama.model.CacheDrama
import com.louis.data.network.drama.model.DramaDraftRaw

interface DramaRepoProtocol {
    suspend fun fetchDrama(): List<DramaDraftRaw>
    suspend fun getDramas(): List<DramaDraftRaw>
    suspend fun getDrama(func1: Func1<CacheDrama,Int>): DramaDraftRaw
}