package com.github.yoviep.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.yoviep.database.entity.AreaEntity
import kotlinx.coroutines.flow.Flow


/**
 * @created 01-05-2022 05:32
 * @author yoviekaputra
 * @project eFishery
 **/

@Dao
interface AreaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<AreaEntity>)

    @Query("SELECT * FROM area")
    fun get(): Flow<List<AreaEntity>>
}