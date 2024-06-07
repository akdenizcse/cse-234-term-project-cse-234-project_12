package com.example.health_tracker.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.health_tracker.R


val colors1 = listOf(Color(0xFFFFEBD4), Color(0xFFFCE0D7), Color(0xFFFFFDC5))

@Preview(showSystemUi = true)
@Composable
fun TrackerSection() {
    Column(
        modifier = Modifier
            .background(brush = Brush.verticalGradient(colors = colors1))
            .fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFC8E3ED)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .width(339.dp)
                .height(91.dp)
                .padding(1.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Relaxing",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 5.dp),
                    fontStyle = FontStyle.Italic
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                        .padding(start = 15.dp)
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Image(
                        painterResource(
                            id = R.drawable.medicine_2
                        ),
                        contentDescription = "Meditation",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.size(41.dp)
                    )
                    Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                        Text(
                            text = "Accutane: 2h 16m",
                            style = TextStyle(
                                fontSize = 26.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                                letterSpacing = 0.36.sp,
                            )
                        )
                    }
                }
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFC8E3ED)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .width(339.dp)
                .height(91.dp)
                .padding(1.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Walking",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 5.dp),
                    fontStyle = FontStyle.Italic
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                        .padding(start = 15.dp)
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Image(
                        painterResource(
                            id = R.drawable.walk
                        ),
                        contentDescription = "Meditation",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.size(41.dp)
                    )
                    Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                        Text(
                            text = "0",
                            style = TextStyle(
                                fontSize = 36.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                                letterSpacing = 0.36.sp,
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Steps",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                                letterSpacing = 0.2.sp,
                            ),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFC8E3ED)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .width(339.dp)
                .height(91.dp)
                .padding(1.dp)
                .align(Alignment.CenterHorizontally)
        )
        {
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Hydration",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 5.dp),
                    fontStyle = FontStyle.Italic
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                        .padding(start = 15.dp)
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Image(
                        painterResource(
                            id = R.drawable.water
                        ),
                        contentDescription = "Meditation",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.size(41.dp)
                    )
                    Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                        Text(
                            text = "0,0",
                            style = TextStyle(
                                fontSize = 36.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                                letterSpacing = 0.36.sp,
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Liters",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                                letterSpacing = 0.2.sp,
                            ),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFC8E3ED)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .width(339.dp)
                .height(91.dp)
                .padding(1.dp)
                .align(Alignment.CenterHorizontally)
        )
        {
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Sleep",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 5.dp),
                    fontStyle = FontStyle.Italic
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                        .padding(start = 15.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Image(
                        painterResource(
                            id = R.drawable.resource_double
                        ),
                        contentDescription = "Meditation",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.size(41.dp)
                    )
                    Text(
                        text = "0h 0m",
                        style = TextStyle(
                            fontSize = 36.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                            letterSpacing = 0.36.sp,
                        )
                    )
                }
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFC8E3ED)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .width(339.dp)
                .height(91.dp)
                .padding(1.dp)
                .align(Alignment.CenterHorizontally)
        )
        {
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Relaxing",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 5.dp),
                    fontStyle = FontStyle.Italic
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                        .padding(start = 15.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Image(
                        painterResource(
                            id = R.drawable.meditation
                        ),
                        contentDescription = "Meditation",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.size(41.dp)
                    )
                    Text(
                        text = "0m 0s",
                        style = TextStyle(
                            fontSize = 36.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                            letterSpacing = 0.36.sp,
                        )
                    )
                }
            }
        }


    }
}

