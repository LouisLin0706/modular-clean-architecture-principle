package com.louis.data.network.drama

import com.louis.data.network.drama.model.DramaDraftRaw
import retrofit2.Call

interface DramaApiClientSpec {
    fun fetchDramas(): Call<List<DramaDraftRaw>>
}