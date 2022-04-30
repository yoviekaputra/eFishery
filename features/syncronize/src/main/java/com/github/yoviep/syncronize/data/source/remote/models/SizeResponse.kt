package com.github.yoviep.syncronize.data.source.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SizeResponse(
    @field:Json(name = "size")
    val size: String
)
