package com.example.health_tracker.datastore

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class StoreHydration(private val context: Context) {

    companion object{
        private val Context.dataStore : DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore("Hydration")
        val HYDRATION   = doublePreferencesKey("Hydration")
    }


    val getHydration : Flow<Double?> = context.dataStore.data
        .map { preferences ->
            preferences[HYDRATION] ?: 0.0
        }

    suspend fun saveHydration(value : Double) {
        context.dataStore.edit { preferences ->
            preferences[HYDRATION] = value
        }
    }
}


