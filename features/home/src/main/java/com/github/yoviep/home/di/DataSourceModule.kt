package com.github.yoviep.home.di

import com.github.yoviep.home.data.source.LocalDataSource
import com.github.yoviep.home.data.source.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 01-05-2022 15:34
 * @author yoviekaputra
 * @project eFishery
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindLocalDataSource(
        dataSource: LocalDataSourceImpl
    ): LocalDataSource
}