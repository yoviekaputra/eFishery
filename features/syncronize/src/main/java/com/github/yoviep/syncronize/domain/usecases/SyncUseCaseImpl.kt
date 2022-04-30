package com.github.yoviep.syncronize.domain.usecases

import com.github.yoviep.syncronize.domain.repository.SyncRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject


/**
 * @created 30-04-2022 14:04
 * @author yoviekaputra
 * @project eFishery
 **/

class SyncUseCaseImpl @Inject constructor(
    private val repository: SyncRepository
) : SyncUseCase {

    override suspend fun invoke(): Unit = coroutineScope {
        val synchronizing = listOf(
            async {
                repository.syncCommodities()
            },
            async {
                repository.syncAreas()
            },
            async {
                repository.syncSizes()
            }
        )

        synchronizing.awaitAll()
    }
}