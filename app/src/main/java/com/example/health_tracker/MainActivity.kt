package com.example.health_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.health_tracker.ui.theme.Health_TrackerTheme
import com.example.health_tracker.ui.theme.Screens.ForgotPassword
import com.example.health_tracker.ui.theme.Screens.HealthSection
import com.example.health_tracker.ui.theme.Screens.LoginForm

import com.example.health_tracker.ui.theme.Screens.SignUp
import com.example.health_tracker.ui.theme.Screens.TrackerSection
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Health_TrackerTheme {

                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentScreen = HealthTrackerScreen.valueOf(
                    backStackEntry?.destination?.route ?: HealthTrackerScreen.Login.name
                )

                NavHost(navController = navController, startDestination = HealthTrackerScreen.Login.name) {
                    composable(HealthTrackerScreen.Login.name){
                        LoginForm(navController = navController)
                    }

                    composable(HealthTrackerScreen.SignUp.name){
                        SignUp(navController = navController)
                    }

                    composable(HealthTrackerScreen.ForgetPassword.name){
                        ForgotPassword(navController = navController)
                    }

                    composable(HealthTrackerScreen.Health.name){
                        HealthSection()
                    }
                }
            }
        }
    }
}
