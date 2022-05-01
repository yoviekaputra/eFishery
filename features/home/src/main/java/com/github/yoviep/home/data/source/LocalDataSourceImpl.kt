package com.github.yoviep.home.data.source

import com.github.yoviep.abstractions.di.IoDispatcher
import com.github.yoviep.database.dao.CommodityDao
import com.github.yoviep.database.entity.CommodityEntity
import com.github.yoviep.home.domain.models.CommodityFilter
import com.github.yoviep.home.domain.models.Sorting
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
 * @created 01-05-2022 15:35
 * @author yoviekaputra
 * @project eFishery
 **/

class LocalDataSourceImpl @Inject constructor(
    private val commodityDao: CommodityDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : LocalDataSource {

    override fun get(filter: CommodityFilter): Flow<List<CommodityEntity>> {
        val args = mutableListOf<Any>()
        val query = StringBuilder("SELECT * FROM commodity")

        // compose filter by area
        filter.filterByArea?.let { area ->
            query.append(" WHERE area_province LIKE upper('%' || ? || '%'")
            args.add(area)
        }

        // compose sort
        when (filter.sortBy) {
            is Sorting.HighestSize -> {
                query.append(" ORDER BY size + 0 DESC")
            }
            is Sorting.LowestSize -> {
                query.append(" ORDER BY size + 0 ASC")
            }
            is Sorting.HighestPrice -> {
                query.append(" ORDER BY price + 0 DESC")
            }
            is Sorting.LowestPrice -> {
                query.append(" ORDER BY price + 0 ASC")
            }
            else -> {
                // filter.sortBy is null
            }
        }

        return commodityDao.query(query = query.toString(), args = args.toTypedArray())
            .flowOn(ioDispatcher)
    }

    override fun getLowestPrice() = commodityDao.getLowestPrice()
        .flowOn(ioDispatcher)

    override fun getHighestPrice() = commodityDao.getHighestPrice()
        .flowOn(ioDispatcher)

    override fun getLowestSize() = commodityDao.getLowestSize()
        .flowOn(ioDispatcher)

    override fun getHighestSize() = commodityDao.getHighestSize()
        .flowOn(ioDispatcher)

    override fun getByCommodity(commodity: String) = commodityDao.getByCommodity(
        commodity = commodity
    ).flowOn(ioDispatcher)

    override fun getByAreaProvince(areaProvince: String) = commodityDao.getByAreaProvince(
        areaProvince = areaProvince
    ).flowOn(ioDispatcher)
}