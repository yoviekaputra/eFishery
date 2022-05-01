package com.github.yoviep.home.di

import com.github.yoviep.home.data.repository.CommodityRepositoryImpl
import com.github.yoviep.home.domain.repository.CommodityRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 01-05-2022 15:33
 * @author yoviekaputra
 * @project eFishery
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCommodityRepository(
        repository: CommodityRepositoryImpl
    ): CommodityRepository
}