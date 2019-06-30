package com.louis.data.database.dao

import android.text.TextUtils
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.louis.data.database.composeSortString
import com.louis.data.database.composeWhereString
import com.louis.data.database.drama.DramaDatabase
import com.louis.data.database.drama.model.CacheDrama
import com.louis.data.database.drama.model.Sort
import java.util.*

@Dao
abstract class CacheDramaDao {

    @RawQuery
    abstract fun fetchDramas(query: SupportSQLiteQuery): List<CacheDrama>

    private fun getCondition(vararg sorts: Sort): MutableList<String> {
        val condition = ArrayList<String>()
        for (sort in sorts) {
            if (TextUtils.equals(sort.column, CacheDrama.VIEW_COUNT)) {
                break
            }
        }
        return condition
    }

    fun fetchDramas(vararg sorts: Sort): List<CacheDrama> {
        val query = StringBuilder("SELECT * FROM " + DramaDatabase.TABLE_NAME)

        val condition = getCondition(*sorts)
        query.append(condition.composeWhereString())
        query.append(Arrays.asList<Sort>(*sorts).composeSortString())

        val simpleSQLiteQuery = SimpleSQLiteQuery(query.toString())
        return fetchDramas(simpleSQLiteQuery)
    }

    @Query("SELECT * FROM " + DramaDatabase.TABLE_NAME + " WHERE dramaId IN (:dramaIds)")
    abstract fun getCacheDramasByIds(vararg dramaIds: Int): List<CacheDrama>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(cacheDrama: List<CacheDrama>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(cacheDrama: CacheDrama): Long

}