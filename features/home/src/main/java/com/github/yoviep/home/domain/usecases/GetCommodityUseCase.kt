package com.github.yoviep.home.domain.usecases

import com.github.yoviep.home.domain.models.Commodity
import com.github.yoviep.home.domain.models.CommodityFilter
import kotlinx.coroutines.flow.Flow


/**
 * @created 01-05-2022 15:19
 * @author yoviekaputra
 * @project eFishery
 **/

interface GetCommodityUseCase {

    operator fun invoke(filter: CommodityFilter): Flow<List<Commodity>>
}