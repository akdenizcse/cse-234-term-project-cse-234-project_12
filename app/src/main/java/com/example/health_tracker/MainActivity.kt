package com.example.health_tracker

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.health_tracker.data.checkForPermission
import com.example.health_tracker.data.isInternetAvailable
import com.example.health_tracker.ui.theme.Health_TrackerTheme
import com.example.health_tracker.ui.theme.Screens.ActivityHistoryScreen
import com.example.health_tracker.ui.theme.Screens.AddActivityScreen
import com.example.health_tracker.ui.theme.Screens.ForgotPassword
import com.example.health_tracker.ui.theme.Screens.InternetConnectionScreen
import com.example.health_tracker.ui.theme.Screens.LocationPermissionScreen
import com.example.health_tracker.ui.theme.Screens.LoginForm
import com.example.health_tracker.ui.theme.Screens.ProfileSettings
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.health_tracker.data.ActivityViewModel
import com.example.health_tracker.data.ResetDataWorker
import com.example.health_tracker.database.ActivityDatabase
import java.util.concurrent.TimeUnit

import com.example.health_tracker.ui.theme.Screens.SignUp
import java.util.Calendar

class MainActivity : ComponentActivity() {


    companion object {
        lateinit var ActivityDatabase: ActivityDatabase
    }
    private lateinit var activityViewModel: ActivityViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityViewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)


        enableEdgeToEdge()
        val midnight = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }.timeInMillis

        val currentTime = System.currentTimeMillis()
        val delay = if (midnight > currentTime) midnight - currentTime else 24 * 60 * 60 * 1000

        val resetDataWorkRequest = PeriodicWorkRequestBuilder<ResetDataWorker>(24, TimeUnit.HOURS)
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "ResetData",
            ExistingPeriodicWorkPolicy.KEEP,
            resetDataWorkRequest
        )
        setContent {

            Health_TrackerTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    var hasLocationPermission by remember {
                        mutableStateOf(checkForPermission(this))
                    }
                    var hasInternetPermission by remember {
                        mutableStateOf(checkForPermission(this))
                    }
                    val networkStatusTracker = NetworkStatusTracker(this)
                    hasInternetPermission = networkStatusTracker.networkStatus.collectAsState().value

                    if (hasLocationPermission && hasInternetPermission) {
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
                                MainPart(
                                    context = this@MainActivity,
                                    navController = navController,
                                    activityViewModel = activityViewModel
                                )
                            }

                            composable(HealthTrackerScreen.ActivityHistory.name) {
                                ActivityHistoryScreen(
                                    navController = navController,
                                    activityViewModel
                                )
                            }

                            composable(HealthTrackerScreen.AddActivity.name) {
                                AddActivityScreen(navController = navController, activityViewModel)
                            }
                            composable(HealthTrackerScreen.ProfileSetting.name) {
                                ProfileSettings(navController = navController) // TODO: remove comment
                            }
                        }
                    }else {
                        if (!hasInternetPermission) {
                            InternetConnectionScreen(this) {
                                hasInternetPermission = true
                            }
                        }
                        if (!hasLocationPermission && hasInternetPermission) {
                            LocationPermissionScreen {
                                hasLocationPermission = true
                            }
                        }
                    }


                }
            }
        }
    }
}





