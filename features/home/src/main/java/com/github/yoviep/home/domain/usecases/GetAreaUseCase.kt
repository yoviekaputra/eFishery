package com.github.yoviep.home.domain.usecases

import com.github.yoviep.home.domain.models.Area
import kotlinx.coroutines.flow.Flow


/**
 * @created 01-05-2022 15:19
 * @author yoviekaputra
 * @project eFishery
 **/

interface GetAreaUseCase {

    operator fun invoke(): Flow<List<Area>>
}