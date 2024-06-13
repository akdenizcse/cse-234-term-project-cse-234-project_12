package com.example.health_tracker.ui.theme.Screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.example.health_tracker.HealthTrackerScreen
import com.example.health_tracker.R


@Composable
fun ActivityHistoryScreen(
    navController: NavController
){
    val gradientColors = listOf(Color(0xFFFFEBD4), Color(0xFFFCE0D7), Color(0xFFFFFDC5))
    val greyscaleMatrix = ColorMatrix().apply {
        setToSaturation(1f)
    }
    var searchText by remember { mutableStateOf("") }
    val yourCardDataList = listOf(
        "Push Day",
        "Pull Day",
        "Leg Day"
    )

    Column(
        modifier = Modifier

            .fillMaxWidth()
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(gradientColors)
            )
    ) {
        Text(
            text = "Previous Activities",
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 100.dp, top = 50.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))

        Box(modifier = Modifier
            .height(450.dp)
            .fillMaxSize()
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RectangleShape
            )){

            LazyColumn(
                modifier = Modifier
                    .height(450.dp)
                    .fillMaxWidth()
            ) {

                items(yourCardDataList){
                        cardData ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Card(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 20.dp)
                                .shadow(
                                    elevation = 20.dp,
                                    shape = RoundedCornerShape(12.dp),
                                    spotColor = Color.Black
                                )
                                .width(297.dp)
                                .height(72.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFC8E3ED))
                        ) {
                            Text(text = "Push Day",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                ),
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 10.dp))
                            Spacer(modifier = Modifier.height(3.dp))

                            Text(text = "Incline Bench Press",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 10.sp,
                                ),
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 5.dp)
                            )
                        }

                        Image(painter = painterResource(id = R.drawable.remove_4),
                            contentDescription = "Remove button",
                            colorFilter = ColorFilter.colorMatrix(greyscaleMatrix),
                            modifier = Modifier
                                .clickable {

                                }
                                .padding(start = 30.dp, top = 20.dp)
                                .size(30.dp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){


                        Card(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 20.dp)
                                .shadow(
                                    elevation = 20.dp,
                                    shape = RoundedCornerShape(12.dp),
                                    spotColor = Color.Black
                                )
                                .width(297.dp)
                                .height(72.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFC8E3ED))
                        ) {
                            Text(text = "Pull Day",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                ),
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 10.dp))
                            Spacer(modifier = Modifier.height(3.dp))

                            Text(text = "Lat Pulldown",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 10.sp,
                                ),
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 5.dp)
                            )
                        }

                        Image(painter = painterResource(id = R.drawable.remove_4),
                            contentDescription = "Remove button",
                            colorFilter = ColorFilter.colorMatrix(greyscaleMatrix),
                            modifier = Modifier
                                .padding(start = 30.dp, top = 20.dp)
                                .size(30.dp)
                        )
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        Card(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 20.dp)
                                .shadow(
                                    elevation = 20.dp,
                                    shape = RoundedCornerShape(12.dp),
                                    spotColor = Color.Black
                                )
                                .width(297.dp)
                                .height(72.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFC8E3ED))
                        ) {
                            Text(text = "Leg Day",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                ),
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 10.dp))
                            Spacer(modifier = Modifier.height(3.dp))

                            Text(text = "Leg Press",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 10.sp,
                                ),
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 5.dp)
                            )
                        }
                        Image(painter = painterResource(id = R.drawable.remove_4),
                            contentDescription = "Remove button",
                            colorFilter = ColorFilter.colorMatrix(greyscaleMatrix),
                            modifier = Modifier
                                .padding(start = 30.dp, top = 20.dp)
                                .size(30.dp)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(40.dp))

        Row (

        ){
            Button(onClick = { navController.navigate(HealthTrackerScreen.Main.name) },
                colors = ButtonColors(
                    containerColor = Color(0xFFC8E3ED),
                    contentColor = Color.Black,
                    disabledContainerColor = Color(0xFFC8E3ED),
                    disabledContentColor = Color.Black),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                modifier = Modifier
                    .padding(start = 290.dp)
            ) {
                Text(
                    text = "Back",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.width(5.dp))
                Image(painter = painterResource(id = R.drawable.turn_back_1),
                    contentDescription = "Turn back icon",
                    modifier = Modifier
                        .size(20.dp))
            }

        }
    }
}


