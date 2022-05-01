package com.github.yoviep.syncronize.data.source.remote.models

import com.github.yoviep.database.entity.CommodityEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * @created 30-04-2022 14:14
 * @author yoviekaputra
 * @project eFishery
 **/

@JsonClass(generateAdapter = true)
data class CommodityResponse(
    @Json(name = "uuid")
    val uuid: String?,
    @Json(name = "area_kota")
    val areaCity: String?,
    @Json(name = "area_provinsi")
    val areaProvince: String?,
    @Json(name = "komoditas")
    val commodity: String?,
    @Json(name = "price")
    val price: String?,
    @Json(name = "size")
    val size: String?,
    @Json(name = "tgl_parsed")
    val tglParsed: String?,
    @Json(name = "timestamp")
    val timestamp: String?
)

fun CommodityResponse.asEntity() = CommodityEntity(
    uuid = uuid.orEmpty(),
    areaCity = areaCity,
    areaProvince = areaProvince,
    commodity = commodity,
    price = price,
    size = size,
    tglParsed = tglParsed,
    timestamp = timestamp
)

fun List<CommodityResponse>.asEntity() = map {
    it.asEntity()
}