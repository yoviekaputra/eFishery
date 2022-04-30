package com.github.yoviep.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "area")
data class AreaEntity(
    @PrimaryKey
    @ColumnInfo(name = "province")
    val province: String,
    @ColumnInfo(name = "city")
    val city: String
)
