package com.github.yoviep.syncronize.data.repository

import com.github.yoviep.syncronize.domain.repository.SyncRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject


/**
 * @created 30-04-2022 14:02
 * @author yoviekaputra
 * @project eFishery
 **/

class SyncRepositoryImpl @Inject constructor(

) : SyncRepository {

    override suspend fun sync(): Flow<Unit> {
        return flowOf()
    }
}