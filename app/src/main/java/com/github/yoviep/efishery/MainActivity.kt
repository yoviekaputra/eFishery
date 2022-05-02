package com.github.yoviep.efishery

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.github.yoviep.home.presentation.ui.HomeActivity
import com.github.yoviep.syncronize.worker.SyncWorker
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initObserver()
        viewModel.getCommodity()
    }

    private fun initObserver() {
        with(viewModel) {
            errorMessage.observe(this@MainActivity) {
                Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
            }

            prepared.observe(this@MainActivity) {
                initWorker()
                navigateToHomeScreen()
            }

            syncFinished.observe(this@MainActivity) {
                navigateToHomeScreen()
            }
        }
    }

    private fun initWorker() {
        val workManager = WorkManager.getInstance(this)

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val sync =
            PeriodicWorkRequestBuilder<SyncWorker>(15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()

        workManager.enqueue(sync)
    }

    private fun navigateToHomeScreen() {
        val home = Intent(this@MainActivity, HomeActivity::class.java)
        startActivity(home)
        finish()
    }
}