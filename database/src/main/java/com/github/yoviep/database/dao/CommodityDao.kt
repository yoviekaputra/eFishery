package com.github.yoviep.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.yoviep.database.entity.CommodityEntity
import kotlinx.coroutines.flow.Flow


/**
 * @created 01-05-2022 05:32
 * @author yoviekaputra
 * @project eFishery
 **/

@Dao
interface CommodityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<CommodityEntity>)

    @Query("SELECT * FROM commodity")
    fun get(): Flow<List<CommodityEntity>>

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