package com.github.yoviep.home.domain.repository

import com.github.yoviep.home.domain.models.Area
import kotlinx.coroutines.flow.Flow


/**
 * @created 01-05-2022 15:13
 * @author yoviekaputra
 * @project eFishery
 **/

interface AreaRepository {

    fun get(): Flow<List<Area>>
}