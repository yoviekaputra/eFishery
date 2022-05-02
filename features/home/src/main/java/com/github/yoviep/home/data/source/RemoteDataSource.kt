package com.github.yoviep.home.data.source

import com.github.yoviep.home.data.source.remote.models.AddResponse
import com.github.yoviep.syncronize.data.source.remote.models.CommodityResponse
import kotlinx.coroutines.flow.Flow


/**
 * @created 02-05-2022 14:48
 * @author yoviekaputra
 * @project eFishery
 **/

interface RemoteDataSource {

    fun add(commodities: List<CommodityResponse>): Flow<AddResponse>
}