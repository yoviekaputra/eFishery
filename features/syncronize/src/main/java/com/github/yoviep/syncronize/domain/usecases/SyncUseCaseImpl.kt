package com.github.yoviep.syncronize.domain.usecases

import com.github.yoviep.syncronize.domain.repository.SyncRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/**
 * @created 30-04-2022 14:04
 * @author yoviekaputra
 * @project eFishery
 **/

class SyncUseCaseImpl @Inject constructor(
    private val repository: SyncRepository
) : SyncUseCase {

    override fun invoke(): Flow<Unit> {
        return flow {
            repository.sync()
        }
    }
}