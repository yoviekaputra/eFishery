package com.github.yoviep.syncronize.di

import com.github.yoviep.syncronize.domain.usecases.SyncUseCase
import com.github.yoviep.syncronize.domain.usecases.SyncUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 30-04-2022 14:00
 * @author yoviekaputra
 * @project eFishery
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindSyncUseCase(
        useCase: SyncUseCaseImpl
    ): SyncUseCase
}