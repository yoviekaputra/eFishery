package com.github.yoviep.syncronize.data.source.local

import com.github.yoviep.abstractions.di.IoDispatcher
import com.github.yoviep.database.dao.AreaDao
import com.github.yoviep.database.dao.CommodityDao
import com.github.yoviep.database.dao.SizeDao
import com.github.yoviep.database.entity.AreaEntity
import com.github.yoviep.database.entity.CommodityEntity
import com.github.yoviep.database.entity.SizeEntity
import com.github.yoviep.syncronize.data.source.LocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * @created 01-05-2022 05:57
 * @author yoviekaputra
 * @project eFishery
 **/

class LocalDataSourceImpl @Inject constructor(
    private val areaDao: AreaDao,
    private val commodityDao: CommodityDao,
    private val sizeDao: SizeDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : LocalDataSource {

    override suspend fun insertArea(data: List<AreaEntity>) = withContext(ioDispatcher) {
        areaDao.insert(data)
    }

    override suspend fun insertCommodity(data: List<CommodityEntity>) = withContext(ioDispatcher) {
        commodityDao.insert(data)
    }

    override suspend fun insertSize(data: List<SizeEntity>)  = withContext(ioDispatcher) {
        sizeDao.insert(data)
    }
}