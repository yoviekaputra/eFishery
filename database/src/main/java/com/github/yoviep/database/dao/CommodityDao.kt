package com.github.yoviep.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.github.yoviep.database.entity.CommodityEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * @created 01-05-2022 05:32
 * @author yoviekaputra
 * @project eFishery
 **/

@Dao
interface CommodityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<CommodityEntity>)

    @RawQuery
    fun get(query: SupportSQLiteQuery): List<CommodityEntity>

    fun query(query: String, args: Array<Any>): Flow<List<CommodityEntity>> {
        return flow {
            emit(get(query = SimpleSQLiteQuery(query, args)))
        }
    }
}