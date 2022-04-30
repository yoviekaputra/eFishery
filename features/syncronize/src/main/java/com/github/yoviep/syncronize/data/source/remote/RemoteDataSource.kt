package com.github.yoviep.syncronize.data.source.remote

import com.github.yoviep.syncronize.data.source.remote.models.AreaResponse
import com.github.yoviep.syncronize.data.source.remote.models.CommodityResponse
import com.github.yoviep.syncronize.data.source.remote.models.SizeResponse


/**
 * @created 30-04-2022 14:21
 * @author yoviekaputra
 * @project eFishery
 **/

interface RemoteDataSource {

    suspend fun getCommodities(): List<CommodityResponse>

    suspend fun getAreas(): List<AreaResponse>

    suspend fun getSizes(): List<SizeResponse>
}