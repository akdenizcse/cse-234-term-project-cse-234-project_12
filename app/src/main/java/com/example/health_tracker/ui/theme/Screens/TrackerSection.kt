package com.example.health_tracker.ui.theme.Screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.health_tracker.R
import com.example.health_tracker.datastore.StoreHydration
import com.example.health_tracker.datastore.StoreMedication
import com.example.health_tracker.datastore.StoreRelaxing
import com.example.health_tracker.datastore.StoreSleep
import com.example.health_tracker.datastore.StoreWalking
import com.example.health_tracker.ui.theme.Screens.Map.MapScreen
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


@SuppressLint("MutableCollectionMutableState")
@Composable
fun TrackerSection(context: Context) {

    val colors1 = listOf(Color(0xFFFFEBD4), Color(0xFFFCE0D7), Color(0xFFFFFDC5))
    val medicationStore = StoreMedication(context)
    val currentLiters = remember { mutableStateOf(0.0) } // Initial liter value
    val currentWalk = remember { mutableStateOf(0) } // Initial liter value
    val sleepTime = remember { mutableStateOf(0) }
    val currentRelaxing = remember { mutableStateOf(0) } // Initial liter value
    var currentMedication = remember { mutableStateOf("") }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val hydrationStore = StoreHydration(context)
    val sleepStore = StoreSleep(context)
    val walkingStore = StoreWalking(context)
    val relaxingStore = StoreRelaxing(context)

    LaunchedEffect(Unit) {
        launch {
            val initialValue = hydrationStore.getHydration
            currentLiters.value = initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        scope.launch {
            val medicationName = medicationStore.getMedicationName.first()!!
            val medicationHour = medicationStore.getMedicationHour.first()!!
            val medicationMinute = medicationStore.getMedicationMinute.first()!!

            // Combine the values into a single string
            currentMedication.value = "$medicationName $medicationHour:$medicationMinute"
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = sleepStore.getSleep
            sleepTime.value = initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = walkingStore.getSteps
            currentWalk.value= initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = relaxingStore.getRelaxing
            currentRelaxing.value = initialValue.first()!!
        }
    }

    Column(
        modifier = Modifier
            .background(brush = Brush.verticalGradient(colors = colors1))
            .padding(top = 100.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(35.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
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
                    .width(250.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Column {
                    Text(
                        text = "Activity Route",
                        style = TextStyle(
                            fontSize = 36.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black,
                            letterSpacing = 0.36.sp,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )
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
                    .height(150.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Column(modifier = Modifier.align(Alignment.CenterHorizontally), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    MapScreen(context)
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
                .height(80.dp)
                .padding(1.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Medication",
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
                            text = "${currentMedication.value}",
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
                .height(80.dp)
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
                        contentDescription = "Walk",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.size(41.dp)
                    )
                    Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                        Text(
                            text = currentWalk.value.toString(),
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
                .height(80.dp)
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
                        contentDescription = "Hydration",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.size(41.dp)
                    )
                    Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                        Text(
                            text = currentLiters.value.toString(),
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
        Row(modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(40.dp)) {
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
                    .width(150.dp)
                    .height(91.dp)
                    .padding(1.dp)
                    .align(Alignment.CenterVertically)
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
                            contentDescription = "Sleep",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(41.dp)
                        )
                        Text(
                            text = "${sleepTime.value/60}h ${sleepTime.value%60}m ",
                            style = TextStyle(
                                fontSize = 25.sp,
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
                    .width(150.dp)
                    .height(91.dp)
                    .padding(1.dp)
                    .align(Alignment.CenterVertically)
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
                            contentDescription = "Relaxing",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(41.dp)
                        )
                        Text(
                            text = "${currentRelaxing.value/60}m",
                            style = TextStyle(
                                fontSize = 25.sp,
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

}

