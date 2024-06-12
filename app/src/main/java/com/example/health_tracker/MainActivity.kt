package com.example.health_tracker

import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.health_tracker.data.checkForPermission
import com.example.health_tracker.ui.theme.Health_TrackerTheme
import com.example.health_tracker.ui.theme.Screens.AddActivityScreen
import com.example.health_tracker.ui.theme.Screens.ForgotPassword
import com.example.health_tracker.ui.theme.Screens.HealthSection
import com.example.health_tracker.ui.theme.Screens.LocationPermissionScreen
import com.example.health_tracker.ui.theme.Screens.LoginForm
import com.example.health_tracker.ui.theme.Screens.ProfilePage

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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var hasLocationPermission by remember {
                        mutableStateOf(checkForPermission(this))
                    }

                    if (hasLocationPermission) {
                        val navController = rememberNavController()
                        val backStackEntry by navController.currentBackStackEntryAsState()
                        val currentScreen = HealthTrackerScreen.valueOf(
                            backStackEntry?.destination?.route ?: HealthTrackerScreen.Login.name
                        )

                        NavHost(
                            navController = navController,
                            startDestination = HealthTrackerScreen.Login.name
                        ) {
                            composable(HealthTrackerScreen.Login.name) {
                                LoginForm(navController = navController)
                            }

                            composable(HealthTrackerScreen.SignUp.name) {
                                SignUp(navController = navController)
                            }

                            composable(HealthTrackerScreen.ForgetPassword.name) {
                                ForgotPassword(navController = navController)
                            }

                            composable(HealthTrackerScreen.Main.name) {
                                MainPart(context = this@MainActivity)
                            }
                        }
                    } else {
                        LocationPermissionScreen {
                            hasLocationPermission = true
                        }
                    }


                }
            }
        }
    }

}


