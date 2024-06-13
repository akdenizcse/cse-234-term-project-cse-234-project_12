package com.example.health_tracker.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreGoal(private val context: Context) {

    companion object{
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("Goal")
        val GOAL   = doublePreferencesKey("Goal")
    }


    val getGoal : Flow<Double?> = context.dataStore.data
        .map { preferences ->
            preferences[GOAL] ?: 0.0
        }

    suspend fun saveGoal(value : Double) {
        context.dataStore.edit { preferences ->
            preferences[GOAL] = value
        }
    }
}