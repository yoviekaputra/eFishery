package com.github.yoviep.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.yoviep.database.dao.AreaDao
import com.github.yoviep.database.dao.CommodityDao
import com.github.yoviep.database.dao.SizeDao
import com.github.yoviep.database.entity.AreaEntity
import com.github.yoviep.database.entity.CommodityEntity
import com.github.yoviep.database.entity.SizeEntity


/**
 * @created 01-05-2022 05:43
 * @author yoviekaputra
 * @project eFishery
 **/

@Database(
    entities = [
        AreaEntity::class,
        CommodityEntity::class,
        SizeEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun areaDao(): AreaDao

    abstract fun commodityDao(): CommodityDao

    abstract fun sizeDao(): SizeDao
}