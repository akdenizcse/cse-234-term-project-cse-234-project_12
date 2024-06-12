package com.example.health_tracker.ui.theme.Screens.Map

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.health_tracker.data.getCurrentLocation
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.MapProperties

@SuppressLint("MutableCollectionMutableState")
@Composable
fun MapScreen(context: Context) {
    var showMap by remember { mutableStateOf(false) }
    var location by remember { mutableStateOf(LatLng(0.0, 0.0)) }
    var mapProperties by remember { mutableStateOf(MapProperties()) }
    var list by remember { mutableStateOf(mutableListOf<LatLng>())}
    getCurrentLocation(context) {
        location = it
        showMap = true
        list.add(it)
    }

    if (showMap) {
        MyMap(
            context = context,
            latLng = location,
            mapProperties = mapProperties,
            totalLoc = list
            )
    } else {
        Text(text = "Loading Map...",modifier = Modifier, textAlign = TextAlign.Center)
        Log.d("Location",location.toString())
    }
}