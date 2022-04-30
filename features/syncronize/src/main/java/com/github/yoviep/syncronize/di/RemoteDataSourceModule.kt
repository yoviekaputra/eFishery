package com.github.yoviep.syncronize.di

import com.github.yoviep.syncronize.data.source.remote.RemoteDataSource
import com.github.yoviep.syncronize.data.source.remote.impl.RemoteDataSourceImpl
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
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        dataSource: RemoteDataSourceImpl
    ): RemoteDataSource
}