package com.github.yoviep.database.dao

import androidx.room.*
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

    @Query("SELECT * FROM commodity ORDER BY price ASC")
    fun getLowestPrice(): Flow<List<CommodityEntity>>

    @Query("SELECT * FROM commodity ORDER BY price DESC")
    fun getHighestPrice(): Flow<List<CommodityEntity>>

    @Query("SELECT * FROM commodity ORDER BY size ASC")
    fun getLowestSize(): Flow<List<CommodityEntity>>

    @Query("SELECT * FROM commodity ORDER BY size DESC")
    fun getHighestSize(): Flow<List<CommodityEntity>>

    @Query("SELECT * FROM commodity WHERE commodity LIKE upper('%' || :commodity || '%')")
    fun getByCommodity(commodity: String): Flow<List<CommodityEntity>>

    @Query("""
        SELECT * FROM commodity WHERE area_province LIKE upper('%' || :areaProvince || '%')
    """)
    fun getByAreaProvince(areaProvince: String): Flow<List<CommodityEntity>>
}