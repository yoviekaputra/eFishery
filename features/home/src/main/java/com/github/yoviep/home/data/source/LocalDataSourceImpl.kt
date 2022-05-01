package com.github.yoviep.home.data.source

import com.github.yoviep.abstractions.di.IoDispatcher
import com.github.yoviep.database.dao.AreaDao
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
    private val areaDao: AreaDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : LocalDataSource {

    override fun get(filter: CommodityFilter): Flow<List<CommodityEntity>> {
        val args = mutableListOf<Any>()
        val query = StringBuilder("SELECT * FROM commodity")

        if (filter.filterByArea != null || filter.name != null) {
            query.append(" WHERE ")

            // compose filter by area
            filter.filterByArea?.let { area ->
                query.append("area_province LIKE upper('%' || ? || '%') AND ")
                args.add(area)
            }

            filter.name?.let { keyword ->
                query.append("commodity LIKE upper('%' || ? || '%') AND ")
                args.add(keyword)
            }

            // balance query connotation
            query.append("1 = 1")
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

    override fun getAreas() = areaDao.get().flowOn(ioDispatcher)
}