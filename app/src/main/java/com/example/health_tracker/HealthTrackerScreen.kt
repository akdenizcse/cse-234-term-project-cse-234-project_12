package com.example.health_tracker

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.health_tracker.ui.theme.Screens.ForgotPassword
import com.example.health_tracker.ui.theme.Screens.LoginForm
import com.example.health_tracker.ui.theme.Screens.SignUp

enum class HealthTrackerScreen(@StringRes val title: Int) {
    Login(title = R.string.login),
    SignUp(title = R.string.sign_up),
    Profile(title = R.string.profile),
    ForgetPassword(title = R.string.forget_password),
    Health(title = R.string.health),
    Tracker(title = R.string.tracker),
    Activities(title = R.string.activities)

}



fun contactUs(){
    //TODO will send e-mail to support
}