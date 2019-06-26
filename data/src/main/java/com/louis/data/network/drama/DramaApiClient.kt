package com.louis.data.network.drama

import com.louis.data.network.common.SampleHttpClient
import com.louis.data.network.common.gson.SampleApiGson
import com.louis.data.network.config.APIConfig
import com.louis.data.network.drama.model.DramaDraftRaw
import com.louis.data.network.drama.service.DramaService
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DramaApiClient(okHttpClient: OkHttpClient = SampleHttpClient.getStandardClient()) : DramaApiClientSpec {
    private val dramaService: DramaService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(APIConfig.DOMAIN_API)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(SampleApiGson.createStandardAPIGson()))
            .build()
        dramaService = retrofit.create(DramaService::class.java)
    }

    override fun fetchDramas(): Call<List<DramaDraftRaw>> {
        return dramaService.fetchDramas()
    }

}