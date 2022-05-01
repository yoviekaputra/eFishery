package com.github.yoviep.home.di

import com.github.yoviep.home.domain.usecases.AddCommodityUseCase
import com.github.yoviep.home.domain.usecases.GetAreaUseCase
import com.github.yoviep.home.domain.usecases.GetCommodityUseCase
import com.github.yoviep.home.presentation.usecases.AddCommodityUseCaseImpl
import com.github.yoviep.home.presentation.usecases.GetAreaUseCaseImpl
import com.github.yoviep.home.presentation.usecases.GetCommodityUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


/**
 * @created 01-05-2022 15:31
 * @author yoviekaputra
 * @project eFishery
 **/

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindAddCommodityUseCase(
        useCase: AddCommodityUseCaseImpl
    ): AddCommodityUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetCommodityUseCase(
        useCase: GetCommodityUseCaseImpl
    ): GetCommodityUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetCommodityByProvinceUseCase(
        useCase: GetAreaUseCaseImpl
    ): GetAreaUseCase
}