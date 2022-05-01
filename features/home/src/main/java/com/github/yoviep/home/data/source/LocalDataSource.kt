package com.github.yoviep.home.data.source

import com.github.yoviep.database.entity.AreaEntity
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

    fun getAreas(): Flow<List<AreaEntity>>
}