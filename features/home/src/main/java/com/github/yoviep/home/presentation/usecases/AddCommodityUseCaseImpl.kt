package com.github.yoviep.home.presentation.usecases

import com.github.yoviep.home.domain.models.Commodity
import com.github.yoviep.home.domain.repository.CommodityRepository
import com.github.yoviep.home.domain.usecases.AddCommodityUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @created 01-05-2022 15:28
 * @author yoviekaputra
 * @project eFishery
 **/

class AddCommodityUseCaseImpl @Inject constructor(
    private val repository: CommodityRepository
) : AddCommodityUseCase {

    override fun invoke(commodity: Commodity): Flow<String> {
        return repository.add(commodity = commodity)
    }
}