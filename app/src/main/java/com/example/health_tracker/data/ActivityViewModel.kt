package com.example.health_tracker.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.health_tracker.MainActivity
import com.example.health_tracker.MyApplication
import com.example.health_tracker.database.ActivityEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//val activities = mutableStateListOf<Map<Map<String,List<String>>, List<String>>>()
//val logActivites = mutableStateListOf<Map<Map<String,List<String>>, List<String>>>()
class ActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val database = MyApplication.database
    val activitiesDao = database.activityDao()

    val activitiesList: LiveData<List<ActivityEntity>> = activitiesDao.getAllActivities()

    suspend fun addActivity(activity: ActivityEntity) = viewModelScope.launch {
        viewModelScope.launch(Dispatchers.IO) {
            activitiesDao.addActivity(
                ActivityEntity(
                    0,
                    activity.title,
                    activity.savedDays,
                    activity.checkedItems
                )
            )
        }

    }

    suspend fun markActivityAsDeleted(activity: ActivityEntity) = viewModelScope.launch {
        val updatedActivity = activity.copy(deleted = true)
        activitiesDao.updateActivity(updatedActivity)
    }
}
