package com.example.health_tracker.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreRelaxing( private val context: Context) {

    companion object{
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("Relaxing")
        val RELAXING   = intPreferencesKey("Relaxing")
    }


    val getRelaxing : Flow<Int?> = context.dataStore.data
        .map { preferences ->
            preferences[RELAXING] ?: 0
        }

    suspend fun saveRelaxing(value : Int) {
        context.dataStore.edit { preferences ->
            preferences[RELAXING] = value
        }
    }
}