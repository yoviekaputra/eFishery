package com.github.yoviep.syncronize.data.source.remote.api

import com.github.yoviep.network.models.ApiConstant
import com.github.yoviep.syncronize.data.source.remote.models.AreaResponse
import com.github.yoviep.syncronize.data.source.remote.models.CommodityResponse
import com.github.yoviep.syncronize.data.source.remote.models.SizeResponse
import retrofit2.http.GET


/**
 * @created 30-04-2022 14:23
 * @author yoviekaputra
 * @project eFishery
 **/

interface ApiService {

    @GET("${ApiConstant.API_V1}/list")
    suspend fun getCommodities(): List<CommodityResponse>

    @GET("${ApiConstant.API_V1}/option_area")
    suspend fun getAreas(): List<AreaResponse>

    @GET("${ApiConstant.API_V1}/option_size")
    suspend fun getSizes(): List<SizeResponse>
}