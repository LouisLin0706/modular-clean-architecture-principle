package com.louis.data.database.drama.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.louis.data.database.drama.DramaDatabase
import java.util.*

@Entity(tableName = DramaDatabase.TABLE_NAME)
data class CacheDrama(

    @PrimaryKey
    val dramaId: Int,
    val dramaName: String,
    val totalViews: Int,
    val createdAt: Date,
    val thumbUrl: String,
    val rating: Double
)