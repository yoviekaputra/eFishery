package com.github.yoviep.syncronize.data.repository

import com.github.yoviep.syncronize.data.source.remote.RemoteDataSource
import com.github.yoviep.syncronize.domain.repository.SyncRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject


/**
 * @created 30-04-2022 14:02
 * @author yoviekaputra
 * @project eFishery
 **/

class SyncRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : SyncRepository {

    override suspend fun sync(): Unit = coroutineScope {
        val synchronizing = listOf(
            async {
                syncCommodities()
            },
            async {
                syncAreas()
            },
            async {
                syncSizes()
            }
        )

        synchronizing.awaitAll()
    }

    private suspend fun syncCommodities() {
        remoteDataSource.getCommodities()
    }

    private suspend fun syncAreas() {
        remoteDataSource.getAreas()
    }

    private suspend fun syncSizes() {
        remoteDataSource.getSizes()
    }
}