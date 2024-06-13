package com.example.health_tracker.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {
    val activities = mutableStateListOf<Map<Map<String,List<String>>, List<String>>>()
    val logActivites = mutableStateListOf<Map<Map<String,List<String>>, List<String>>>()


}