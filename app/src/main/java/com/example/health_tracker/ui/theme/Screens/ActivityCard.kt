package com.example.health_tracker.ui.theme.Screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.health_tracker.R


@Composable
fun ActivityCard (title: String, exercise: List<String>){
    val greyscaleMatrix = ColorMatrix().apply {
        setToSaturation(1f)
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
                .height(90.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFC8E3ED))
        ) {
            Text(
                text = title,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                ),
                modifier = Modifier
                    .padding(start = 20.dp, top = 10.dp)
            )
            Spacer(modifier = Modifier.height(3.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .clipToBounds()
                    .wrapContentSize(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(1.dp)
                ){
                 items(exercise.size) { i ->
                    Text(
                        text = exercise[i],
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