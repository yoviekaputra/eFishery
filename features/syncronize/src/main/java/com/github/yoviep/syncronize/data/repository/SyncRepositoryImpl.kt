package com.github.yoviep.syncronize.data.repository

import com.github.yoviep.syncronize.data.source.LocalDataSource
import com.github.yoviep.syncronize.data.source.RemoteDataSource
import com.github.yoviep.syncronize.data.source.remote.models.asEntity
import com.github.yoviep.syncronize.domain.repository.SyncRepository
import javax.inject.Inject


/**
 * @created 30-04-2022 14:02
 * @author yoviekaputra
 * @project eFishery
 **/

class SyncRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : SyncRepository {

    override suspend fun syncCommodities() {
        val commodities = remoteDataSource.getCommodities()
        localDataSource.insertCommodity(data = commodities.asEntity())
    }

    override suspend fun syncAreas() {
        val areas = remoteDataSource.getAreas()
        localDataSource.insertArea(data = areas.asEntity())
    }

    override suspend fun syncSizes() {
        val sizes = remoteDataSource.getSizes()
        localDataSource.insertSize(data = sizes.asEntity())
    }
}