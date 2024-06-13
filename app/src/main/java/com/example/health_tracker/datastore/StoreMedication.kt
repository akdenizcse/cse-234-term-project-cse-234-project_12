package com.example.health_tracker.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreMedication(private val context: Context) {

    companion object{
        val Context.dataStore : DataStore<Preferences> by preferencesDataStore("Medication")
        val MEDICATION_NAME = stringPreferencesKey("medication_name")
        val MEDICATION_HOUR = intPreferencesKey("medication_hour")
        val MEDICATION_MINUTE = intPreferencesKey("medication_minute")
    }

    val getMedicationName : Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[MEDICATION_NAME] ?: ""
        }

    val getMedicationHour : Flow<Int?> = context.dataStore.data
        .map { preferences ->
            preferences[MEDICATION_HOUR] ?: 0
        }

    val getMedicationMinute : Flow<Int?> = context.dataStore.data
        .map { preferences ->
            preferences[MEDICATION_MINUTE] ?: 0
        }

    suspend fun saveMedication(name: String, hour: Int, minute: Int) {
        context.dataStore.edit { preferences ->
            preferences[MEDICATION_NAME] = name
            preferences[MEDICATION_HOUR] = hour
            preferences[MEDICATION_MINUTE] = minute
        }
    }
}