package com.github.yoviep.home.presentation.usecases

import com.github.yoviep.home.domain.models.Commodity
import com.github.yoviep.home.domain.models.CommodityFilter
import com.github.yoviep.home.domain.repository.CommodityRepository
import com.github.yoviep.home.domain.usecases.GetCommodityUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @created 01-05-2022 15:29
 * @author yoviekaputra
 * @project eFishery
 **/

class GetCommodityUseCaseImpl @Inject constructor(
    private val repository: CommodityRepository
) : GetCommodityUseCase {

    override fun invoke(filter: CommodityFilter): Flow<List<Commodity>> {
        return repository.get(filter = filter)
    }
}