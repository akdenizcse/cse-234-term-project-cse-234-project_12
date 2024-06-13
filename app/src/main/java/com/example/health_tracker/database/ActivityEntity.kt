package com.example.health_tracker.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activity_table")
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val savedDays: List<String>,
    val checkedItems: List<String>,
    val deleted: Boolean = false
)