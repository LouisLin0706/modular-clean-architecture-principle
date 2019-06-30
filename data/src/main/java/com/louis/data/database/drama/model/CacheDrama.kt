package com.louis.data.database.drama.model

import androidx.annotation.StringDef
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.louis.data.database.DbSort
import com.louis.data.database.convert.DateConverter
import com.louis.data.database.drama.DramaDatabase
import com.louis.data.database.drama.model.CacheDrama.Companion.CREATE_AT
import com.louis.data.database.drama.model.CacheDrama.Companion.RATING_COUNT
import com.louis.data.database.drama.model.CacheDrama.Companion.VIEW_COUNT
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Entity(tableName = DramaDatabase.TABLE_NAME)
data class CacheDrama(

    @PrimaryKey
    val dramaId: Int,
    val dramaName: String,
    @ColumnInfo(name = VIEW_COUNT) val totalViews: Int,
    @ColumnInfo(name = CREATE_AT)
    @TypeConverters(DateConverter::class) val createdAt: Long,
    val thumbUrl: String,
    @ColumnInfo(name = RATING_COUNT) val rating: Double
) {

    companion object {
        const val VIEW_COUNT = "view_count"
        const val CREATE_AT = "create_at"
        const val RATING_COUNT = "rating_count"
    }
}

class Sort : DbSort {
    constructor(@DramaSort column: String) : super(column, true) {}

    constructor(@DramaSort column: String, asc: Boolean) : super(column, asc) {}
}


@StringDef(RATING_COUNT, VIEW_COUNT, CREATE_AT)
@Retention(RetentionPolicy.SOURCE)
annotation class DramaSort