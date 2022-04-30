package com.github.yoviep.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.github.yoviep.database.entity.AreaEntity
import com.github.yoviep.database.entity.SizeEntity


/**
 * @created 01-05-2022 05:32
 * @author yoviekaputra
 * @project eFishery
 **/

@Dao
interface AreaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<AreaEntity>)
}