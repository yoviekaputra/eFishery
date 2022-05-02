package com.github.yoviep.home.data.source.remote.api

import com.github.yoviep.home.data.source.remote.models.AddResponse
import com.github.yoviep.network.models.ApiConstant
import com.github.yoviep.syncronize.data.source.remote.models.CommodityResponse
import retrofit2.http.Body
import retrofit2.http.POST


/**
 * @created 02-05-2022 14:52
 * @author yoviekaputra
 * @project eFishery
 **/

interface ApiService {

    @POST("${ApiConstant.API_V1}/list")
    suspend fun addCommodity(@Body commodities: Any): AddResponse
}