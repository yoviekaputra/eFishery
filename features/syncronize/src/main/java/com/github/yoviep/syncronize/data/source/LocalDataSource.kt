package com.github.yoviep.syncronize.data.source

import com.github.yoviep.database.entity.AreaEntity
import com.github.yoviep.database.entity.CommodityEntity
import com.github.yoviep.database.entity.SizeEntity


/**
 * @created 01-05-2022 05:53
 * @author yoviekaputra
 * @project eFishery
 **/

interface LocalDataSource {

    suspend fun insertArea(data: List<AreaEntity>)

    suspend fun insertCommodity(data: List<CommodityEntity>)

    suspend fun insertSize(data: List<SizeEntity>)
}