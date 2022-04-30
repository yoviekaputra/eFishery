package com.github.yoviep.syncronize.data.repository

import android.util.Log
import com.github.yoviep.syncronize.data.source.remote.RemoteDataSource
import com.github.yoviep.syncronize.domain.repository.SyncRepository
import javax.inject.Inject


/**
 * @created 30-04-2022 14:02
 * @author yoviekaputra
 * @project eFishery
 **/

class SyncRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : SyncRepository {

    override suspend fun syncCommodities() {
        remoteDataSource.getCommodities()
        Log.d("SyncRepositoryImpl", "syncCommodities")
    }

    override suspend fun syncAreas() {
        remoteDataSource.getAreas()
        Log.d("SyncRepositoryImpl", "syncAreas")
    }

    override suspend fun syncSizes() {
        remoteDataSource.getSizes()
        Log.d("SyncRepositoryImpl", "syncSizes")
    }
}