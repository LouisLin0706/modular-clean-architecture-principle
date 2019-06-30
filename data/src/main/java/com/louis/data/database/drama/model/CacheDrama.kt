package com.louis.data.database.drama.model

import androidx.annotation.StringDef
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.louis.data.database.ConditionOperation
import com.louis.data.database.DbQuery
import com.louis.data.database.DbSort
import com.louis.data.database.Operation
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
    @ColumnInfo(name = ID) val dramaId: Int,
    @ColumnInfo(name = DRAMA_NAME) val dramaName: String,
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
        const val DRAMA_NAME = "drama_name"
        const val ID = "id"
    }
}

class Sort : DbSort {
    constructor(@DramaSort column: String) : super(column, true) {}

    constructor(@DramaSort column: String, asc: Boolean) : super(column, asc) {}
}

class Query(@DramaQuery column: String, operation: Operation, raw: String, conditionOperation: ConditionOperation) :
    DbQuery(column, operation, raw, conditionOperation)


@StringDef(CacheDrama.DRAMA_NAME, CacheDrama.ID)
@Retention(RetentionPolicy.SOURCE)
annotation class DramaQuery

@StringDef(RATING_COUNT, VIEW_COUNT, CREATE_AT)
@Retention(RetentionPolicy.SOURCE)
annotation class DramaSort