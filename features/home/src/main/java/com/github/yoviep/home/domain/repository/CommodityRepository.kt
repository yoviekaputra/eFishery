package com.github.yoviep.home.domain.repository

import com.github.yoviep.home.domain.models.Commodity
import com.github.yoviep.home.domain.models.CommodityFilter
import kotlinx.coroutines.flow.Flow


/**
 * @created 01-05-2022 15:13
 * @author yoviekaputra
 * @project eFishery
 **/

interface CommodityRepository {

    fun get(filter: CommodityFilter): Flow<List<Commodity>>

    fun add(commodity: Commodity): Flow<String>
}