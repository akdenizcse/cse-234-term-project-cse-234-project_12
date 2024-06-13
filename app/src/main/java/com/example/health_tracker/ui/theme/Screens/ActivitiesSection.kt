package com.example.health_tracker.ui.theme.Screens

import android.annotation.SuppressLint
import android.widget.Space
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.health_tracker.HealthTrackerScreen
import com.example.health_tracker.R
import com.example.health_tracker.data.ActivityViewModel


@SuppressLint("MutableCollectionMutableState")
@Composable
fun ActivitiesScreen(navController: NavController, viewModel: ActivityViewModel) {
    val gradientColors = listOf(Color(0xFFFFEBD4), Color(0xFFFCE0D7), Color(0xFFFFFDC5))
    val greyscaleMatrix = ColorMatrix().apply {
        setToSaturation(1f)
    }





    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(gradientColors)
            )
    ) {
        // Search bar

        Text(
            text = "Active Activities",
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 100.dp,top = 60.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .height(450.dp)
                .fillMaxSize()
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RectangleShape
                )
        ) {

            LazyColumn(
                modifier = Modifier
                    .height(450.dp)
                    .fillMaxWidth()
            ) {

                items(viewModel.activities.size) { i ->

                    val activity = viewModel.activities[i]
                    val titleAndDayMap = activity.keys.first()
                    val title = titleAndDayMap.keys.first()
                    val day = titleAndDayMap[title]
                    val exercises = activity[titleAndDayMap]
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                        Image(painter = painterResource(id = R.drawable.remove_4),
                            contentDescription = "Remove button",
                            colorFilter = ColorFilter.colorMatrix(greyscaleMatrix),
                            modifier = Modifier
                                .clickable {
                                    viewModel.activities.removeAt(i)
                                    viewModel.logActivites.add(activity)
                                }
                                .padding(start = 30.dp, top = 20.dp)
                                .size(30.dp)


                        )
                        ActivityCard(title = "$title - $day", exercise = exercises ?: listOf())

                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))


        }

        Row(modifier = Modifier.padding(top = 20.dp)) {
            Button(
                onClick = { navController.navigate(HealthTrackerScreen.ActivityHistory.name) },
                colors = ButtonColors(
                    containerColor = Color(0xFFC8E3ED),
                    contentColor = Color.Black,
                    disabledContainerColor = Color(0xFFC8E3ED),
                    disabledContentColor = Color.Black
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                modifier = Modifier
                    .padding(start = 15.dp)
            ) {
                Text(
                    text = "Activity History",
                    style = TextStyle(
                        fontSize = 13.sp
                    )
                )
            }
            Spacer(modifier = Modifier.width(170.dp))

            Image(painter = painterResource(id = R.drawable.add),
                contentDescription = "Add button",
                modifier = Modifier
                    .clickable { navController.navigate(HealthTrackerScreen.AddActivity.name) }
                    .size(50.dp))

        }

    }
}


