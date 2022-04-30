package com.github.yoviep.syncronize.data.source.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * @created 30-04-2022 14:14
 * @author yoviekaputra
 * @project eFishery
 **/

@JsonClass(generateAdapter = true)
data class CommodityResponse(
    @field:Json(name = "area_kota")
    val areaCity: String?,
    @field:Json(name = "area_provinsi")
    val areaProvince: String?,
    @field:Json(name = "komoditas")
    val commodity: String?,
    @field:Json(name = "price")
    val price: String?,
    @field:Json(name = "size")
    val size: String?,
    @field:Json(name = "tgl_parsed")
    val tglParsed: String?,
    @field:Json(name = "timestamp")
    val timestamp: String?,
    @field:Json(name = "uuid")
    val uuid: String?
)