package com.example.health_tracker

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.example.health_tracker.data.isInternetAvailable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NetworkStatusTracker(context: Context) : ConnectivityManager.NetworkCallback() {

    private val _networkStatus = MutableStateFlow(isInternetAvailable(context))
    val networkStatus: StateFlow<Boolean> get() = _networkStatus

    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .build()

    init {
        connectivityManager.registerNetworkCallback(networkRequest, this)
    }

    override fun onAvailable(network: Network) {
        _networkStatus.value = true
    }

    override fun onLost(network: Network) {
        _networkStatus.value = false
    }
}