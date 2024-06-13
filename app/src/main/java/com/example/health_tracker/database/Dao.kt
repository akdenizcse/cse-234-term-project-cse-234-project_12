package com.example.health_tracker.database
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ActivityDao {
    @Query("SELECT * FROM activity_table")
    fun getAllActivities(): LiveData<List<ActivityEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addActivity(activity: ActivityEntity)

    @Query("DELETE FROM activity_table WHERE id = :id")
    fun deleteActivity(id: Int)

    @Update
    fun updateActivity(activity: ActivityEntity)

}