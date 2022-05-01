package com.github.yoviep.home.data.repository

import com.github.yoviep.home.data.mapper.asDomain
import com.github.yoviep.home.data.source.LocalDataSource
import com.github.yoviep.home.domain.models.Area
import com.github.yoviep.home.domain.repository.AreaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * @created 01-05-2022 15:33
 * @author yoviekaputra
 * @project eFishery
 **/

class AreaRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : AreaRepository {

    override fun get(): Flow<List<Area>> {
        return localDataSource.getAreas()
            .map {
                it.asDomain()
            }
    }
}