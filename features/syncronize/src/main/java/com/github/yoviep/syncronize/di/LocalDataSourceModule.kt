package com.github.yoviep.syncronize.di

import com.github.yoviep.syncronize.data.source.LocalDataSource
import com.github.yoviep.syncronize.data.source.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 30-04-2022 14:28
 * @author yoviekaputra
 * @project eFishery
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindLocalDataSource(
        dataSource: LocalDataSourceImpl
    ): LocalDataSource
}