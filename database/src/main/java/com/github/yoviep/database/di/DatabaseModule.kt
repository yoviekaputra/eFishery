package com.github.yoviep.database.di

import android.content.Context
import androidx.room.Room
import com.github.yoviep.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 01-05-2022 05:45
 * @author yoviekaputra
 * @project eFishery
 **/

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "eFishery-test.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideAreaDao(appDatabase: AppDatabase) = appDatabase.areaDao()

    @Provides
    @Singleton
    fun provideCommodityDao(appDatabase: AppDatabase) = appDatabase.commodityDao()

    @Provides
    @Singleton
    fun provideSizeDao(appDatabase: AppDatabase) = appDatabase.sizeDao()
}