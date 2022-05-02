package com.github.yoviep.home.data.source.remote

import com.github.yoviep.abstractions.di.IoDispatcher
import com.github.yoviep.home.data.source.RemoteDataSource
import com.github.yoviep.home.data.source.remote.api.ApiService
import com.github.yoviep.home.data.source.remote.models.AddResponse
import com.github.yoviep.syncronize.data.source.remote.models.CommodityResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
 * @created 02-05-2022 14:51
 * @author yoviekaputra
 * @project eFishery
 **/

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {

    override fun add(commodities: List<CommodityResponse>): Flow<AddResponse> {
        return flow {
            emit(
                apiService.addCommodity(commodities = commodities)
            )
        }.flowOn(ioDispatcher)
    }
}