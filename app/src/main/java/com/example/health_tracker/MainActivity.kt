package com.example.health_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.health_tracker.ui.theme.Health_TrackerTheme
import com.example.health_tracker.ui.theme.Screens.HealthSection
import com.example.health_tracker.ui.theme.Screens.LoginForm
import com.example.health_tracker.ui.theme.Screens.SignUp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Health_TrackerTheme {
                HealthSection()
            }
        }
    }
}
