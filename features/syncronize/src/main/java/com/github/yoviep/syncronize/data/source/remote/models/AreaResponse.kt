package com.github.yoviep.syncronize.data.source.remote.models

import com.github.yoviep.database.entity.AreaEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AreaResponse(
    @field:Json(name = "city")
    val city: String,
    @field:Json(name = "province")
    val province: String
)

fun AreaResponse.asEntity() = AreaEntity(
    city = city,
    province = province
)

fun List<AreaResponse>.asEntity() = map {
    it.asEntity()
}