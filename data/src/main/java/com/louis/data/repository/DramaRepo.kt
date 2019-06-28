package com.louis.data.repository

import com.louis.data.cache.Func1
import com.louis.data.cache.Store
import com.louis.data.database.drama.model.CacheDrama
import com.louis.data.extension.retrofit.await
import com.louis.data.network.drama.DramaApiClientSpec
import com.louis.data.network.drama.model.DramaDraftRaw

open class DramaRepo(
    private val dramaApiClient: DramaApiClientSpec,
    private val store: Store<Int, CacheDrama>
) : DramaRepoProtocol {

    override suspend fun getDrama(func1: Func1<CacheDrama, Int>): DramaDraftRaw {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun fetchDrama(): List<DramaDraftRaw> {
        val data = dramaApiClient.fetchDramas().await()
        //TODO SAVE IN CACHE
        return data
    }

    override suspend fun getDramas(): List<DramaDraftRaw> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}