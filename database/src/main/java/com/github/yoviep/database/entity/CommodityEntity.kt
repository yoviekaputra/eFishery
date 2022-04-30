package com.github.yoviep.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * @created 01-05-2022 05:29
 * @author yoviekaputra
 * @project eFishery
 **/

@Entity(tableName = "commodity")
data class CommodityEntity(
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    val uuid: String,
    @ColumnInfo(name = "area_city")
    val areaCity: String?,
    @ColumnInfo(name = "area_province")
    val areaProvince: String?,
    @ColumnInfo(name = "commodity")
    val commodity: String?,
    @ColumnInfo(name = "price")
    val price: String?,
    @ColumnInfo(name = "size")
    val size: String?,
    @ColumnInfo(name = "tgl_parsed")
    val tglParsed: String?,
    @ColumnInfo(name = "timestamp")
    val timestamp: String?
)