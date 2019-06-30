package com.louis.data.database.dao

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.louis.data.database.DbQuery
import com.louis.data.database.composeSortString
import com.louis.data.database.composeWhereString
import com.louis.data.database.drama.DramaDatabase
import com.louis.data.database.drama.model.CacheDrama
import com.louis.data.database.drama.model.Sort

@Dao
abstract class CacheDramaDao {

    @RawQuery
    abstract fun getCacheDramas(query: SupportSQLiteQuery): List<CacheDrama>

    fun getCacheDramas(sortsList: List<Sort> = emptyList(), queryList: List<DbQuery> = emptyList()): List<CacheDrama> {
        val query = StringBuilder("SELECT * FROM " + DramaDatabase.TABLE_NAME)
        query.append(queryList.composeWhereString())
        query.append(sortsList.composeSortString())
        val simpleSQLiteQuery = SimpleSQLiteQuery(query.toString())
        return getCacheDramas(simpleSQLiteQuery)
    }

    @Query("SELECT * FROM " + DramaDatabase.TABLE_NAME + " WHERE ${CacheDrama.ID} IN (:dramaIds)")
    abstract fun getCacheDramasByIds(vararg dramaIds: Int): List<CacheDrama>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(cacheDrama: List<CacheDrama>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(cacheDrama: CacheDrama): Long

    @Query("DELETE FROM " + DramaDatabase.TABLE_NAME)
    abstract fun deleteAll()
}