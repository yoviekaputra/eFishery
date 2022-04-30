package com.github.yoviep.syncronize.domain.repository

import kotlinx.coroutines.flow.Flow


/**
 * @created 30-04-2022 13:56
 * @author yoviekaputra
 * @project eFishery
 **/

interface SyncRepository {

    suspend fun sync() : Flow<Unit>
}