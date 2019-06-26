package com.louis.data.repository

import com.louis.data.network.drama.model.DramaDraftRaw

interface DramaRepoProtocol {
    suspend fun fetchDramaDraftRawList(): List<DramaDraftRaw>
    suspend fun getDramaDraftRawList(): List<DramaDraftRaw>
    suspend fun getDramaDraftRaw(key: Int): DramaDraftRaw
}