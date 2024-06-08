package com.example.health_tracker.ui.theme.Screens

import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.health_tracker.R

@Preview
@Composable
fun ProfilePage(){
    val colors1 = listOf(Color(0xFF979797), Color(0xFFDDD7D7), Color(0xFFF4F4F4))
//Background
    Column(
    modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(colors = colors1)
        )
) {
        InformationBox()
}
}

@Composable
fun InformationBox(){
    val ashColor = Color(0xFF79747E)
Column(modifier = Modifier.fillMaxSize()
    ) {

    //InformationBox
    Card(
        Modifier
            .padding(top = 50.dp, start = (27.5).dp, end = 20.dp)
            .width(337.dp)
            .height(155.dp)
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
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(bottom = 80.dp, start = 5.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.user_filled),
                    contentDescription = "User profile photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(50.dp)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "cn.dundar", style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp
                    )
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Age:26",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp
                    )
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Height:182",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp
                    )
                )
            }

            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(bottom = 5.dp, start = 5.dp)
            ) {

                Text(
                    text = "Can Dündar",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp
                    )
                )

                Spacer(modifier = Modifier.width(100.dp))

                Text(
                    text = "Weight:90",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp
                    ),
                    modifier = Modifier.offset(x = (-15).dp)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Goal:80",
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
                    .padding(bottom = 40.dp)
                    .offset(x = (-20).dp)
            ) {

                Text(
                    text = "Remaining Calories:",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp
                    )
                )

                Spacer(modifier = Modifier.width(60.dp))
                Text(
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
                    .padding(bottom = 10.dp)
                    .offset(x = (-20).dp)
            ) {

                //Shows the remaining calories
                Text(
                    text = "1991",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 25.sp
                    ),
                    modifier = Modifier.offset(x = (-20).dp)
                )

                Spacer(modifier = Modifier.width(60.dp))

                //Shows the number of steps taken
                Text(
                    text = "0",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 25.sp
                    ),
                    modifier = Modifier.offset(x = 40.dp)
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(200.dp))
//OptionBox
    Card(
        modifier = Modifier
            .padding(bottom = 5.dp, start = 40.dp, end = 20.dp)
            .width(314.dp)
            .height(200.dp)
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
        ) {
            Column(modifier = Modifier.align(Alignment.CenterStart)) {
                Text(
                    text = "Change Profile Settings",
                    modifier = Modifier
                        .clickable(
                            onClickLabel = "Open change profile settings"
                        ) {

                        }
                        .padding(start = 60.dp, bottom = 10.dp)
                        .then(Modifier.drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            val color = Color.White
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
                        color = Color.White,
                        fontSize = 15.sp
                    ),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Rate And Comment",
                    modifier = Modifier
                        .clickable(onClickLabel = "Open rate and comment") {

                        }
                        .padding(start = 60.dp, bottom = 10.dp)
                        .then(Modifier.drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            val color = Color.White
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
                    text = "Share With Friends",
                    modifier = Modifier
                        .clickable(onClickLabel = "Open share with friends") {

                        }
                        .padding(start = 60.dp, bottom = 10.dp)
                        .then(Modifier.drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            val color = Color.White
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

                        }
                        .padding(start = 60.dp, bottom = 10.dp)
                        .then(Modifier.drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            val color = Color.White
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
                        color = Color.White,
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