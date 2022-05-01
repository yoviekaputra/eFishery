package com.github.yoviep.home.domain.usecases;

import com.github.yoviep.home.domain.models.Commodity;
import kotlinx.coroutines.flow.Flow

interface AddCommodityUseCase {

    operator fun invoke(commodity: Commodity): Flow<String>
}
