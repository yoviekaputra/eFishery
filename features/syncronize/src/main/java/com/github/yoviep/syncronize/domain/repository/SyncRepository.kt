package com.github.yoviep.syncronize.domain.repository


/**
 * @created 30-04-2022 13:56
 * @author yoviekaputra
 * @project eFishery
 **/

interface SyncRepository {

    suspend fun syncCommodities()

    suspend fun syncAreas()

    suspend fun syncSizes()
}