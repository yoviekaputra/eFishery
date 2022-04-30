package com.github.yoviep.syncronize.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.github.yoviep.syncronize.domain.usecases.SyncUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

/**
 * @created 30-04-2022 09:41
 * @author yoviekaputra
 * @project eFishery
 **/

@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted private val workerParameters: WorkerParameters,
    private val syncUseCase: SyncUseCase
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result = runCatching {
        syncUseCase.invoke()
        Result.success()
    }.getOrElse {
        Log.e(SyncWorker::javaClass.name, it.message, it)
        Result.failure()
    }
}