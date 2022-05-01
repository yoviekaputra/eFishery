package com.github.yoviep.home.presentation.usecases

import com.github.yoviep.home.domain.models.Area
import com.github.yoviep.home.domain.repository.AreaRepository
import com.github.yoviep.home.domain.usecases.GetAreaUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @created 01-05-2022 15:29
 * @author yoviekaputra
 * @project eFishery
 **/

class GetAreaUseCaseImpl @Inject constructor(
    private val repository: AreaRepository
) : GetAreaUseCase {

    override fun invoke(): Flow<List<Area>> {
        return repository.get()
    }
}