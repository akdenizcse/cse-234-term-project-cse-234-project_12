package com.example.health_tracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.util.Date

@Database(entities = [ActivityEntity::class], version = 1)
@TypeConverters(Converters::class,ListStringConverter::class)
abstract class ActivityDatabase : RoomDatabase() {
    abstract fun activityDao(): ActivityDao
}