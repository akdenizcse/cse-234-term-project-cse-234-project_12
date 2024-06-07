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
    ForgetPassword(title = R.string.forget_password)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthTrackerAppBar(
    currentScreen: HealthTrackerScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(text = stringResource(id = currentScreen.title))},
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }


    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthTrackerApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = HealthTrackerScreen.valueOf(
        backStackEntry?.destination?.route ?: HealthTrackerScreen.Login.name
    )

    //TODO: Add ViewModel

    Scaffold (
        topBar ={
            HealthTrackerAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() })

        }
    )
    { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = HealthTrackerScreen.Login.name,
            modifier = Modifier.padding(innerPadding)
        ){

            composable(HealthTrackerScreen.Login.name){
                LoginForm(
                    onForgetPasswordClicked ={
                        navController.navigate(HealthTrackerScreen.ForgetPassword.name)
                    },
                    onSignUpButtonClicked = {
                      navController.navigate(HealthTrackerScreen.SignUp.name)
                    },
                    //TODO navigate to profile
                    /**
                     * for now we will act like the user put the write email and password*/
                    onLoginButtonClicked = {
                        navController.navigate(HealthTrackerScreen.Profile.name)
                    },
                    onContactUsClicked = {
                        contactUs()
                    }
                )
            }


            composable(HealthTrackerScreen.ForgetPassword.name){
                ForgotPassword(
                    onLoginClicked = {
                        navController.navigate(HealthTrackerScreen.Login.name)
                    },
                    onResetPasswordClicked = {
                        //will send e-mail to user
                    }
                )
            }

            composable(HealthTrackerScreen.SignUp.name){
                SignUp(
                    onLoginClicked = {
                        navController.navigate(HealthTrackerScreen.Login.name)
                    },
                    onSignupClicked = {
                        //TODO will send e-mail to user and navigate to login
                        // we will act as the user put the write email and password
                        navController.navigate(HealthTrackerScreen.Login.name)
                    },
                    onContactForSupportClicked = {
                        contactUs()
                    }
                )
            }


        }
    }
}

fun contactUs(){
    //TODO will send e-mail to support
}