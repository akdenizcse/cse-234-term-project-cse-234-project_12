package com.example.health_tracker.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreSleep(private val context: Context) {

    companion object{
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("Sleep")
        val SLEEP   = doublePreferencesKey("Sleep")
    }


    val getSleep : Flow<Double?> = context.dataStore.data
        .map { preferences ->
            preferences[SLEEP] ?: 0.0
        }

    suspend fun saveSleep(value : Double) {
        context.dataStore.edit { preferences ->
            preferences[SLEEP] = value
        }
    }
}