package com.louis.data.network.drama.service

import com.louis.data.network.config.APIConfig
import com.louis.data.network.drama.model.DramaDraftRaw
import retrofit2.Call
import retrofit2.http.GET

interface DramaService {
    @GET(APIConfig.PATH_DRAMAS)
    fun fetchDramas(): Call<List<DramaDraftRaw>>
}