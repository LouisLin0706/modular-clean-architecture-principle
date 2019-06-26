package com.louis.domain.model

import java.util.*

data class Drama(
    val dramaId: Int,
    val dramaName: String,
    val totalViews: Int,
    val createdAt: Date,
    val thumbUrl: String,
    val rating: Double
)