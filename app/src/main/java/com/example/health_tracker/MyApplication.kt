package com.example.health_tracker

import android.app.Application
import androidx.room.Room
import com.example.health_tracker.database.ActivityDatabase

class MyApplication : Application() {

    companion object {
        lateinit var database: ActivityDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            ActivityDatabase::class.java, "activity_database"
        )
            .allowMainThreadQueries() // allow queries on the main thread
            .build()
    }
}