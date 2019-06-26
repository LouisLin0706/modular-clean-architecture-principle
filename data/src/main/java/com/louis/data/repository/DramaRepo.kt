package com.louis.data.repository

import com.louis.data.extension.retrofit.await
import com.louis.data.network.drama.DramaApiClientSpec
import com.louis.data.network.drama.model.DramaDraftRaw

open class DramaRepo(
    private val dramaApiClient: DramaApiClientSpec
) : DramaRepoProtocol {

    override suspend fun getDramaDraftRaw(key: Int): DramaDraftRaw {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun fetchDramaDraftRawList(): List<DramaDraftRaw> {
        val data = dramaApiClient.fetchDramas().await()
        //TODO SAVE IN CACHE
        return data
    }

    override suspend fun getDramaDraftRawList(): List<DramaDraftRaw> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}