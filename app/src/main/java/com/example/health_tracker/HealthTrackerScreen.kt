package com.example.health_tracker

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.health_tracker.ui.theme.Screens.Activities
import com.example.health_tracker.ui.theme.Screens.HealthSection
import com.example.health_tracker.ui.theme.Screens.ProfilePage
import com.example.health_tracker.ui.theme.Screens.TrackerSection


enum class HealthTrackerScreen(@StringRes val title: Int) {
    Login(title = R.string.login),
    SignUp(title = R.string.sign_up),
    ForgetPassword(title = R.string.forget_password),
    Main(title = R.string.entry)
}

enum class MainPart(@StringRes val title: Int){
    Activities(title = R.string.activities),
    Tracker(title = R.string.tracker),
    Health(title = R.string.health),
    Profile(title = R.string.profile)
}

data class BottomNavigationItem(
    @StringRes val title: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int
)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPart(
    modifier: Modifier,
    navController: NavController
){
    val items = listOf(
        BottomNavigationItem(
            title = R.string.activities,
            selectedIcon = R.drawable.dumbell_filled,
            unselectedIcon = R.drawable.dumbell
        ),
        BottomNavigationItem(
            title = R.string.tracker,
            selectedIcon = R.drawable.clock_filled,
            unselectedIcon = R.drawable.clock
        ),
        BottomNavigationItem(
            title = R.string.health,
            selectedIcon = R.drawable.health_filled,
            unselectedIcon = R.drawable.health
        ),
        BottomNavigationItem(
            title = R.string.profile,
            selectedIcon = R.drawable.user,
            unselectedIcon = R.drawable.user_filled
        ),

    )

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    var selectedUserSelection by rememberSaveable {
        mutableStateOf<MainPart?>(null) // Initially no selection
    }

    Surface(
        modifier= Modifier.fillMaxSize(),

    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                selectedUserSelection = when (index) {
                                    0 -> MainPart.Activities
                                    1 -> MainPart.Tracker
                                    2-> MainPart.Health
                                    3 -> MainPart.Profile
                                    // ... other cases based on item index
                                    else -> null
                                }

                            },
                            icon = {
                                Icon(
                                    painter = painterResource(
                                        id = if (selectedItemIndex == index) item.selectedIcon else item.unselectedIcon
                                    ),
                                    contentDescription = item.title.toString()
                                )
                            }

                        )
                    }
                }
            }
        ) {
            when (selectedUserSelection) {
                MainPart.Tracker -> TrackerSection()
                MainPart.Activities -> Activities()
                MainPart.Health -> HealthSection()
                MainPart.Profile -> ProfilePage()
                else -> HealthSection()
            }
        }
    }
}



fun contactUs(){
    //TODO will send e-mail to support
}