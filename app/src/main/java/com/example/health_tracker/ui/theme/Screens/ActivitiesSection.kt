package com.example.health_tracker.ui.theme.Screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.health_tracker.R

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ActivitiesScreen(){
    val gradientColors = listOf(Color(0xFFFFEBD4), Color(0xFFFCE0D7), Color(0xFFFFFDC5))
    var searchText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(gradientColors)
            )
    ) {
        // Search bar
        TextField(value = searchText,
            onValueChange ={searchText = it},
            modifier = Modifier
                .padding(start = 45.dp, top = 20.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(20.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(5.dp)
                )
                .width(294.dp)
                .height(51.dp),
            placeholder = {Text("Search")},
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.search_interface_symbol),
                    contentDescription = "Search icon" ,
                    modifier = Modifier.size(24.dp))
            },
            singleLine = true,//keep the input in single line
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Active Activities",
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 100.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))

        Box(modifier = Modifier
            .fillMaxSize()
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RectangleShape
            )){

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
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
                Spacer(modifier = Modifier.height(10.dp))
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
                Spacer(modifier = Modifier.height(10.dp))
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
            }
        }
    }
}