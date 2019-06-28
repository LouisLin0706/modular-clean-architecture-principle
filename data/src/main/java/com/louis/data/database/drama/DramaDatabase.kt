package com.louis.data.database.drama

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.louis.data.database.convert.DateConverter
import com.louis.data.database.dao.CacheDramaDao
import com.louis.data.database.drama.model.CacheDrama

@Database(entities = [CacheDrama::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class DramaDatabase : RoomDatabase() {

    abstract fun cacheDramaDao(): CacheDramaDao

    companion object {
        const val TABLE_NAME = "DramaTable"
    }
}