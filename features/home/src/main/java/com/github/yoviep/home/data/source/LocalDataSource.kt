package com.github.yoviep.home.data.source

import com.github.yoviep.database.entity.CommodityEntity
import com.github.yoviep.home.domain.models.CommodityFilter
import kotlinx.coroutines.flow.Flow


/**
 * @created 01-05-2022 15:23
 * @author yoviekaputra
 * @project eFishery
 **/

interface LocalDataSource {

    fun get(filter: CommodityFilter): Flow<List<CommodityEntity>>

    fun getLowestPrice(): Flow<List<CommodityEntity>>

    fun getHighestPrice(): Flow<List<CommodityEntity>>

    fun getLowestSize(): Flow<List<CommodityEntity>>

    fun getHighestSize(): Flow<List<CommodityEntity>>

    fun getByCommodity(commodity: String): Flow<List<CommodityEntity>>

    fun getByAreaProvince(areaProvince: String): Flow<List<CommodityEntity>>
}