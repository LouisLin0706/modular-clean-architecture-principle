package com.louis.data.network.drama.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class DramaDraftRaw(
    @SerializedName("drama_id") val dramaId: Int,
    @SerializedName("name") val dramaName: String,
    @SerializedName("total_views") val totalViews: Int,
    @SerializedName("created_at") val createdAt: Date,
    @SerializedName("thumb") val thumbUrl: String,
    @SerializedName("rating") val rating: Double
)