package com.github.yoviep.home.data.repository

import com.github.yoviep.home.data.mapper.asData
import com.github.yoviep.home.data.mapper.asDomain
import com.github.yoviep.home.data.source.LocalDataSource
import com.github.yoviep.home.data.source.RemoteDataSource
import com.github.yoviep.home.domain.models.Commodity
import com.github.yoviep.home.domain.models.CommodityFilter
import com.github.yoviep.home.domain.repository.CommodityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * @created 01-05-2022 15:33
 * @author yoviekaputra
 * @project eFishery
 **/

class CommodityRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : CommodityRepository {

    override fun get(filter: CommodityFilter): Flow<List<Commodity>> {
        return localDataSource.get(filter = filter)
            .map {
                it.asDomain()
            }
    }

    override fun add(commodity: Commodity): Flow<String> {
        return remoteDataSource.add(commodities = listOf(commodity.asData()))
            .map {
                it.updatedRange
            }
    }
}