package com.louis.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.louis.data.database.drama.DramaDatabase
import com.louis.data.database.drama.model.CacheDrama

@Dao
abstract class CacheDramaDao {
    @Query("SELECT * FROM " + DramaDatabase.TABLE_NAME + " WHERE dramaId IN (:dramaIds)")
    abstract fun getCacheDramasByIds(vararg dramaIds: Int): List<CacheDrama>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(vararg cacheDrama: CacheDrama): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(cacheDrama: CacheDrama): Long

}