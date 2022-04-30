package com.github.yoviep.syncronize.data.source.remote

import com.github.yoviep.abstractions.di.IoDispatcher
import com.github.yoviep.syncronize.data.source.RemoteDataSource
import com.github.yoviep.syncronize.data.source.remote.api.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * @created 30-04-2022 14:22
 * @author yoviekaputra
 * @project eFishery
 **/

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {

    override suspend fun getCommodities() = withContext(ioDispatcher) {
        apiService.getCommodities()
    }

    override suspend fun getAreas() = withContext(ioDispatcher) {
        apiService.getAreas()
    }

    override suspend fun getSizes() = withContext(ioDispatcher) {
        apiService.getSizes()
    }
}