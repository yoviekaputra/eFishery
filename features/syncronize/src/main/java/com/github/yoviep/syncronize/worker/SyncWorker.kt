package com.github.yoviep.syncronize.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted

/**
 * @created 30-04-2022 09:41
 * @author yoviekaputra
 * @project eFishery
 **/

@HiltWorker
class SyncWorker(
    @Assisted private val context: Context,
    @Assisted private val workerParameters: WorkerParameters,
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result = runCatching {
        Result.success()
    }.getOrElse {
        Result.failure()
    }
}