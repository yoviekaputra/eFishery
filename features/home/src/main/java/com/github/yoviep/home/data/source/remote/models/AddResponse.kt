package com.github.yoviep.home.data.source.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * @created 02-05-2022 14:53
 * @author yoviekaputra
 * @project eFishery
 **/

@JsonClass(generateAdapter = true)
class AddResponse(
    @Json(name = "updatedRange")
    val updatedRange: String
)