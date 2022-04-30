package com.github.yoviep.syncronize.domain.usecases

import kotlinx.coroutines.flow.Flow


/**
 * @created 30-04-2022 13:55
 * @author yoviekaputra
 * @project eFishery
 **/

interface SyncUseCase {

    operator fun invoke(): Flow<Unit>
}