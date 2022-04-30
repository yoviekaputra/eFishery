package com.github.yoviep.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "size")
data class SizeEntity(
    @PrimaryKey
    @ColumnInfo(name = "size")
    val size: String
)
