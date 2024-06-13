package com.example.health_tracker.ui.theme.Screens

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsClient.getPackageName
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.example.health_tracker.HealthTrackerScreen
import com.example.health_tracker.R
import com.example.health_tracker.datastore.StoreAge
import com.example.health_tracker.datastore.StoreGoal
import com.example.health_tracker.datastore.StoreHeight
import com.example.health_tracker.datastore.StoreName
import com.example.health_tracker.datastore.StoreSurname
import com.example.health_tracker.datastore.StoreWalking
import com.example.health_tracker.datastore.StoreWeight
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

//@Preview
@Composable
fun ProfilePage(navController: NavController) {// TODO: remove comment
    val colors1 = listOf(Color(0xFFFFEBD4), Color(0xFFFCE0D7), Color(0xFFFFFDC5))
//Background
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = colors1)
            )
    ) {
        // TODO: remove comment
        InformationBox(navController)
    }
}

@Composable
// TODO: remove comment
fun InformationBox(navController: NavController) {
    var firebase: Firebase by remember { mutableStateOf(Firebase) }
    val ctx = LocalContext.current
    val ashColor = Color(0xFF79747E)

    val context = LocalContext.current

    val nameStore = StoreName(context)
    val ageStore = StoreAge(context)
    val surnameStore = StoreSurname(context)
    val heightStore = StoreHeight(context)
    val weightStore = StoreWeight(context)
    val goalStore = StoreGoal(context)
    val stepsStore = StoreWalking(context)

    val name = remember { mutableStateOf("") }
    val surname = remember { mutableStateOf("") }
    val age = remember { mutableStateOf(0) }
    val height = remember { mutableStateOf(0) }
    val weight = remember { mutableStateOf(0.0) }
    val goal = remember { mutableStateOf(0.0) }
    val steps = remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        launch {
            val initialValue = nameStore.getName
            name.value = initialValue.first()!!
        }
    }

    LaunchedEffect(Unit) {
        launch {
            val initialValue = surnameStore.getSurname
            surname.value = initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = ageStore.getAge
            age.value = initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = heightStore.getHeight
            height.value = initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = weightStore.getWeight
            weight.value = initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = goalStore.getGoal
            goal.value = initialValue.first()!!
        }
    }

    LaunchedEffect(Unit) {
        launch {
            val initialValue = stepsStore.getSteps
            steps.value = initialValue.first()!!
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp), verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {

        //InformationBox
        Card(
            Modifier
                .padding(top = 40.dp, start = (27.5).dp, end = 20.dp)
                .width(400.dp)
                .height(250.dp)
                .background(
                    color = Color(0xFF79747E),
                    shape = RoundedCornerShape(size = 10.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = ashColor
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFC8E3ED))
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(bottom = 150.dp, end = 10.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.user_filled),
                        contentDescription = "User profile photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(50.dp)
                    )

                    Spacer(modifier = Modifier.width(20.dp))
//
//                Text(
//                    color = Color.Black,
//                    text = "cn.dundar", style = TextStyle(
//                        color = Color.White,
//                        fontSize = 15.sp
//                    )
//                )

                    Spacer(modifier = Modifier.width(80.dp))

                    Text(
                        color = Color.Black,
                        text = "Age:${age.value}",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(
                        color = Color.Black,
                        text = "Height:${height.value}",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    )
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(bottom = 60.dp, start = 5.dp)
                ) {

                    Text(
                        color = Color.Black,
                        text = "${name.value} ${surname.value}",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    )

                    Spacer(modifier = Modifier.width(100.dp))

                    Text(
                        color = Color.Black,
                        text = "Weight:${weight.value}",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp
                        ),
                        modifier = Modifier.offset(x = (-15).dp)
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(
                        color = Color.Black,
                        text = "Goal:${goal.value}",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp
                        ),
                        modifier = Modifier.offset(x = (-15).dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 70.dp)
                        .offset(x = (-20).dp)
                ) {

                    Text(
                        color = Color.Black,
                        text = "Remaining Calories:",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    )

                    Spacer(modifier = Modifier.width(60.dp))
                    Text(
                        color = Color.Black,
                        text = "Steps:",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    )
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 30.dp)
                        .offset(x = (-20).dp)
                ) {

                    //Shows the remaining calories
                    Text(
                        color = Color.Black,
                        text = calculateBMR(weight.value, height.value, age.value),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 25.sp
                        ),
                        modifier = Modifier.offset(x = (-20).dp)
                    )

                    Spacer(modifier = Modifier.width(60.dp))

                    //Shows the number of steps taken
                    Text(
                        color = Color.Black,
                        text = "${steps.value}",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 25.sp
                        ),
                        modifier = Modifier.offset(x = 40.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(75.dp))
//OptionBox
        Card(
            modifier = Modifier
                .padding(bottom = 5.dp, start = 40.dp, end = 20.dp)
                .width(314.dp)
                .height(200.dp)
                .background(
                    color = Color(0xFFC8E3ED),
                    shape = RoundedCornerShape(size = 10.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFC8E3ED)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 20.dp)
                ) {
                    Text(
                        text = "Change Profile Settings",
                        modifier = Modifier
                            .clickable(
                                onClickLabel = "Open change profile settings"
                            ) {// TODO: remove comment
                                navController.navigate(HealthTrackerScreen.ProfileSetting.name)
                            }
                            .padding(start = 60.dp, bottom = 10.dp)
                            .then(Modifier.drawBehind {
                                val strokeWidth = 1.dp.toPx()
                                val color = Color.Black
                                val y = size.height
                                val lineEndX = size.width + 100.dp.toPx()
                                drawLine(
                                    color = color,
                                    start = Offset(0f, y),
                                    end = Offset(lineEndX, y),
                                    strokeWidth = strokeWidth
                                )
                            }),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        ),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Rate And Comment",
                        modifier = Modifier
                            .clickable(onClickLabel = "Open rate and comment") {
                                try {
                                    val intent =
                                        Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse("market://details?id=")
                                        )
                                    intent.setPackage("com.android.vending")
                                    /*
                                     This will automatically not work because
                                     we are not on Google Play Store, If we were,
                                     we could implement it like this.
                                    */
                                    Toast
                                        .makeText(
                                            ctx,
                                            "Unable to find play store",
                                            Toast.LENGTH_LONG
                                        )
                                        .show()
                                    //This one is temporary because it won't create an exception for now!
                                } catch (e: ActivityNotFoundException) {
                                    Toast
                                        .makeText(
                                            ctx,
                                            "Unable to find play store",
                                            Toast.LENGTH_LONG
                                        )
                                        .show()
                                }
                            }
                            .padding(start = 60.dp, bottom = 10.dp)
                            .then(Modifier.drawBehind {
                                val strokeWidth = 1.dp.toPx()
                                val color = Color.Black
                                val y = size.height
                                val lineEndX = size.width + 130.dp.toPx()
                                drawLine(
                                    color = color,
                                    start = Offset(0f, y),
                                    end = Offset(lineEndX, y),
                                    strokeWidth = strokeWidth
                                )
                            }),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        ),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Share With Friends",
                        color = Color.Black,
                        modifier = Modifier
                            .clickable(onClickLabel = "Open share with friends") {
                                val shareIntent = Intent().apply {
                                    action = Intent.ACTION_SEND
                                    putExtra(
                                        Intent.EXTRA_TEXT,
                                        "I am using Health Tracker, you should try it too! It's called Solstice!"
                                    )
                                    type = "text/plain"
                                }
                                val chooser = Intent.createChooser(shareIntent, "Share with")
                                ctx.startActivity(chooser)
                            }

                            .padding(start = 60.dp, bottom = 10.dp)
                            .then(Modifier.drawBehind {
                                val strokeWidth = 1.dp.toPx()
                                val color = Color.Black
                                val y = size.height
                                val lineEndX = size.width + 130.dp.toPx()
                                drawLine(
                                    color = color,
                                    start = Offset(0f, y),
                                    end = Offset(lineEndX, y),
                                    strokeWidth = strokeWidth
                                )
                            }),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp
                        ),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Contact Us",
                        modifier = Modifier
                            .clickable(onClickLabel = "Open contact us") {
                                val i = Intent(Intent.ACTION_SEND)
                                i.putExtra(Intent.EXTRA_EMAIL, "Put Your Mail")
                                i.putExtra(Intent.EXTRA_SUBJECT, "Health Tracker Support")
                                i.putExtra(Intent.EXTRA_TEXT, "Please describe your issue here")
                                i.setType("message/rfc822")
                                ctx.startActivity(
                                    Intent.createChooser(
                                        i,
                                        "Choose an Email client : "
                                    )
                                )
                            }
                            .padding(start = 60.dp, bottom = 10.dp)
                            .then(Modifier.drawBehind {
                                val strokeWidth = 1.dp.toPx()
                                val color = Color.Black
                                val y = size.height
                                val lineEndX = size.width + 180.dp.toPx()
                                drawLine(
                                    color = color,
                                    start = Offset(0f, y),
                                    end = Offset(lineEndX, y),
                                    strokeWidth = strokeWidth
                                )
                            }),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        ),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Log Out",
                        modifier = Modifier
                            .clickable(onClickLabel = "Log Out") {
                                firebase.auth.signOut()
                                // TODO: remove comment
                                navController.navigate(HealthTrackerScreen.Login.name)

                            }
                            .padding(start = 60.dp, bottom = 10.dp)
                            .then(Modifier.drawBehind {
                                val strokeWidth = 1.dp.toPx()
                                val color = Color.Black
                                val y = size.height
                                val lineEndX = size.width + 200.dp.toPx()
                                drawLine(
                                    color = color,
                                    start = Offset(0f, y),
                                    end = Offset(lineEndX, y),
                                    strokeWidth = strokeWidth
                                )
                            }),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        ),
                        textAlign = TextAlign.Center
                    )
                }

            }
        }

        //Navigation
    }
}


fun calculateBMR(weight: Double, height: Int, age: Int): String {

    val bmr = (655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age)).toString()
    for (i in bmr.indices) {
        if (bmr[i] == '.') {
            return bmr.substring(0, i + 2)
        }
    }
    return bmr
}
