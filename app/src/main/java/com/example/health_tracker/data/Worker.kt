package com.example.health_tracker.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.health_tracker.datastore.*

class ResetDataWorker(appContext: Context, workerParams: WorkerParameters):
    CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        val hydrationStore = StoreHydration(applicationContext)
        val sleepStore = StoreSleep(applicationContext)
        val walkingStore = StoreWalking(applicationContext)
        val relaxingStore = StoreRelaxing(applicationContext)
        val medicationStore = StoreMedication(applicationContext)

        hydrationStore.saveHydration(0.0)
        sleepStore.saveSleep(0)
        walkingStore.saveSteps(0)
        relaxingStore.saveRelaxing(0)
        medicationStore.saveMedication("", 0, 0)

        return Result.success()
    }
}