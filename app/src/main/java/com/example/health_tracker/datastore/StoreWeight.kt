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

class StoreWeight(private val context: Context) {

    companion object{
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("Weight")
        val WEIGHT   = doublePreferencesKey("Weight")
    }


    val getWeight : Flow<Double?> = context.dataStore.data
        .map { preferences ->
            preferences[WEIGHT] ?: 0.0
        }

    suspend fun saveWeight(value : Double) {
        context.dataStore.edit { preferences ->
            preferences[WEIGHT] = value
        }
    }
}