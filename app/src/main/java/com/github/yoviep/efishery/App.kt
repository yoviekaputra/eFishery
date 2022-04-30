package com.github.yoviep.efishery

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


/**
 * @created 30-04-2022 14:52
 * @author yoviekaputra
 * @project eFishery
 **/

@HiltAndroidApp
class App : Application(), Configuration.Provider {

    @Inject
    lateinit var workManagerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration() = Configuration.Builder()
        .setWorkerFactory(workManagerFactory)
        .build()
}