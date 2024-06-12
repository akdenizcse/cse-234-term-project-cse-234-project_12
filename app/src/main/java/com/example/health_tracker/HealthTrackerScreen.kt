package com.example.health_tracker

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.health_tracker.ui.theme.Screens.ActivitiesScreen
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

//data class BottomNavigationItem(
//    @StringRes val title: Int,
//    val selectedIcon: ImageVector,
//     val unselectedIcon: ImageVector
//)
data class BottomNavigationItem(
    @StringRes val title: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPart(context: Context){
//    val items = listOf(
//        BottomNavigationItem(
//            title = R.string.activities,
//            selectedIcon = ImageVector.vectorResource(id = R.drawable.dumbell_filled),
//            unselectedIcon = ImageVector.vectorResource(id = R.drawable.dumbell)
//        ),
//        BottomNavigationItem(
//            title = R.string.tracker,
//            selectedIcon = ImageVector.vectorResource(id = R.drawable.clock_filled),
//            unselectedIcon =ImageVector.vectorResource(id = R.drawable.clock)
//        ),
//        BottomNavigationItem(
//            title = R.string.health,
//            selectedIcon = ImageVector.vectorResource(id = R.drawable.health_filled),
//            unselectedIcon = ImageVector.vectorResource(id = R.drawable.health)
//        ),
//        BottomNavigationItem(
//            title = R.string.profile,
//            selectedIcon = ImageVector.vectorResource(id = R.drawable.user_filled),
//            unselectedIcon = ImageVector.vectorResource(id = R.drawable.user)
//        ),
//
//    )
    val items = listOf(
        BottomNavigationItem(
            title = R.string.activities,
            selectedIcon = R.drawable.dumbell_filled,
            unselectedIcon = R.drawable.dumbell
        ),
        BottomNavigationItem(
            title = R.string.tracker,
            selectedIcon = R.drawable.clock_filled,
            unselectedIcon =R.drawable.clock
        ),
        BottomNavigationItem(
            title = R.string.health,
            selectedIcon = R.drawable.health_filled,
            unselectedIcon = R.drawable.health
        ),
        BottomNavigationItem(
            title = R.string.profile,
            selectedIcon = R.drawable.user_filled,
            unselectedIcon = R.drawable.user
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
                NavigationBar(
                    modifier = Modifier.height(90.dp)
                ) {
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
                                val icon = if (selectedItemIndex == index) item.selectedIcon else item.unselectedIcon
                                Image(
                                    painter = painterResource(id = icon),
                                    contentDescription = item.title.toString(),
                                    modifier = Modifier.size(40.dp)
                                )
//                                Icon(
//                                    imageVector = if (selectedItemIndex == index) item.selectedIcon
//                                    else item.unselectedIcon,
//                                    contentDescription = item.title.toString()
//                                )
                            }

                        )
                    }
                }
            }
        ) {
            when (selectedUserSelection) {
                MainPart.Tracker -> TrackerSection(context)
                MainPart.Activities -> ActivitiesScreen()
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