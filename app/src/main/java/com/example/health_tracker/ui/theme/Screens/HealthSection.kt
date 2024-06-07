package com.example.health_tracker.ui.theme.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.health_tracker.R

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun HealthSection() {
    val medications = remember { mutableStateListOf<String>()}
    val colors1 = listOf(Color(0xFF979797), Color(0xFFDDD7D7), Color(0xFFF4F4F4))
    val waterColor = listOf(Color(0xFFD3D3D3), Color(0xFF48DBFB))
    val bedColor = listOf(Color(0xFF6D6027), Color(0xFFD3CBB8))
    val walkingColor = listOf(Color(0xFF7BED9F), Color(0xFFD3D3D3))
    val meditationColor = listOf(Color(0xFF7F8C8D), Color(0xFF000000))
    val medicationDialog = remember { mutableStateOf(false) }
    val waterDialog = remember { mutableStateOf(false) }
    val currentLiters = remember { mutableStateOf(0.0) } // Initial liter value
    val walkDialog = remember { mutableStateOf(false) }
    val currentWalk = remember { mutableStateOf(0) } // Initial liter value
    val sleepDialog = remember { mutableStateOf(false) }
    val currentSleep = remember { mutableStateOf("0h 0m") } // Initial liter value
    val relaxingDialog = remember { mutableStateOf(false) }
    val currentRelaxing = remember { mutableStateOf("30m 0s") } // Initial liter value

    if (waterDialog.value) {
        WaterDialog(waterDialog, currentLiters)
    }
    if (walkDialog.value) {
        WalkDialog(walkDialog, currentWalk)
    }
    if (sleepDialog.value) {
        SleepDialog(sleepDialog, currentSleep)
    }
    if (relaxingDialog.value) {
        RelaxingDialog(relaxingDialog, currentRelaxing)
    }
    if(medicationDialog.value) {
        RecordMedication(medicationDialog, medications)
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                brush = Brush.verticalGradient(colors = colors1)
            )
    ) {
        Card(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(50.dp)
                .width(286.dp)
                .height(196.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFD1FAD2)
            )
        )

        {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.imgbin_green_leaf_with_decorative_lines_lluwwxmr3ethsmzvxyrwccvs7),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(
                            width = 1.dp,
                            color = Color(0xFFD1FAD2),
                            shape = RoundedCornerShape(10.dp)
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.Start),
                        text = "Medication Reminder",
                        style = TextStyle(
                            fontSize = 15.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            color = Color(0xFF000000),
                            letterSpacing = 0.2.sp,
                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable._859207_capsule_drug_medicine_pill_tablet_icon_1),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size((70.dp))
                            .align(Alignment.CenterHorizontally),
                    )
                    Text(
                        text = "Record",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            color = Color(0xFF000000),
                            letterSpacing = 0.2.sp,
                        ),
                        modifier = Modifier
                            .padding(33.dp)
                            .clickable {
                                medicationDialog.value = true
                            }
                            .align(Alignment.CenterHorizontally)
                            .width(150.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = Color(0xFF000000),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .fillMaxSize(),
                        textAlign = TextAlign.Center

                    )


                }

            }
        }

        Row {

            Column {
                Card(
                    modifier = Modifier
                        .padding(30.dp)
                        .width(140.dp)
                        .height(150.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFD1FAD2)
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        Column() {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFD1FAD2),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = waterColor,
                                            startY = 0f,
                                            endY = Float.POSITIVE_INFINITY
                                        )
                                    )
                                    .clickable {
                                        waterDialog.value = true
                                    },
                            ) {


                                Text(
                                    modifier = Modifier
                                        .padding(top = 20.dp, start = 12.dp),
                                    text = "Hydration",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        lineHeight = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Italic,
                                        color = Color(0xFF000000),
                                        letterSpacing = 0.2.sp,
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.water),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .padding(top = 10.dp, start = 5.dp)
                                        .size(45.dp)

                                )
                            }


                        }
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(
                                    start = 20.dp, bottom = 20.dp
                                )
                        ) {
                            Text(
                                text = currentLiters.value.toString(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                fontStyle = FontStyle.Normal,
                            )
                            Text(
                                text = "Liters",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                fontStyle = FontStyle.Normal,
                            )
                        }

                    }
                }
                Card(
                    modifier = Modifier
                        .padding(30.dp)
                        .width(140.dp)
                        .height(150.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFD1FAD2)
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        Column() {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFD1FAD2),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = bedColor,
                                            startY = 0f,
                                            endY = Float.POSITIVE_INFINITY
                                        )
                                    )
                                    .clickable {
                                        sleepDialog.value = true
                                    },
                            )
                            {
                                Text(
                                    modifier = Modifier
                                        .padding(top = 20.dp, start = 12.dp),
                                    text = "Sleep",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        lineHeight = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Italic,
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.2.sp,
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.resource_double),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .padding(top = 10.dp, start = 30.dp)
                                        .size(45.dp)

                                )
                            }


                        }
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(
                                    start = 20.dp, bottom = 20.dp
                                )
                        ) {
                            Text(
                                text = currentSleep.value,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                fontStyle = FontStyle.Normal,
                                color = Color(0xFFFFFFFF)
                            )
                        }

                    }
                }


            }
            Column {
                Card(
                    modifier = Modifier
                        .padding(30.dp)
                        .width(140.dp)
                        .height(150.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFD1FAD2)
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        Column() {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFD1FAD2),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = walkingColor,
                                            startY = 0f,
                                            endY = Float.POSITIVE_INFINITY
                                        )
                                    )
                                    .clickable {
                                        walkDialog.value = true
                                    },
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(top = 20.dp, start = 12.dp),
                                    text = "Walking",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        lineHeight = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Italic,
                                        color = Color(0xFF000000),
                                        letterSpacing = 0.2.sp,
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.walk),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .padding(top = 10.dp, start = 10.dp)
                                        .size(45.dp)

                                )
                            }


                        }
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(
                                    start = 20.dp, bottom = 20.dp
                                )
                        ) {
                            Text(
                                text = currentWalk.value.toString(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                fontStyle = FontStyle.Normal,
                            )
                            Text(
                                text = "Steps",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                fontStyle = FontStyle.Normal,
                            )
                        }

                    }
                }
                Card(
                    modifier = Modifier
                        .padding(30.dp)
                        .width(140.dp)
                        .height(150.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFD1FAD2)
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        Column() {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFD1FAD2),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = meditationColor,
                                            startY = 0f,
                                            endY = Float.POSITIVE_INFINITY
                                        )
                                    )
                                    .clickable {
                                        relaxingDialog.value = true
                                    },
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(top = 20.dp, start = 12.dp),
                                    text = "Relaxing",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        lineHeight = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Italic,
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.2.sp,
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.meditation),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .padding(top = 10.dp, start = 8.dp)
                                        .size(45.dp)

                                )
                            }


                        }
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(
                                    start = 20.dp, bottom = 20.dp
                                )
                        ) {
                            Text(
                                text = currentRelaxing.value,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                fontStyle = FontStyle.Normal,
                                color = Color(0xFFFFFFFF)
                            )

                        }

                    }
                }


            }

        }
    }
}

@Composable
fun RecordMedication(medicationDialog: MutableState<Boolean>, currentMedications: MutableList<String>)
{
    val writtenMedication = remember { mutableStateOf("") }
    if (medicationDialog.value) {
        Dialog(onDismissRequest = { medicationDialog.value = false }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f) // Adjust width as needed
                    .background(color = Color.Transparent)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Update Medication", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(value = writtenMedication.value,  onValueChange = {
                        writtenMedication.value = it
                        currentMedications.add(it)
                    })
                    Row(modifier = Modifier) {
                        Button(
                            onClick = { medicationDialog.value = false }
                        ) {
                            Text("Cancel")
                        }
                        Spacer(modifier = Modifier.size(53.dp))
                        Button(
                            onClick = { medicationDialog.value = false }
                        ) {
                            Text("Save")
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun RelaxingDialog(relaxingDialog: MutableState<Boolean>, currentRelaxing: MutableState<String>) {
    if (relaxingDialog.value) {
        Dialog(onDismissRequest = { relaxingDialog.value = false }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f) // Adjust width as needed
                    .background(color = Color.Transparent)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Edit Relax Time", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = currentRelaxing.value, // Convert double to String
                        onValueChange = {
                            val newValue = it
                            currentRelaxing.value = newValue
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier) {
                        Button(
                            onClick = { relaxingDialog.value = false }
                        ) {
                            Text("Cancel")
                        }
                        Spacer(modifier = Modifier.size(53.dp))
                        Button(
                            onClick = { relaxingDialog.value = false }
                        ) {
                            Text("Save")
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun SleepDialog(sleepDialog: MutableState<Boolean>, currentSleep: MutableState<String>)
{
    if (sleepDialog.value) {
        Dialog(onDismissRequest = { sleepDialog.value = false }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f) // Adjust width as needed
                    .background(color = Color.Transparent)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Edit Sleep Hour", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = currentSleep.value.toString(), // Convert double to String
                        onValueChange = {
                            val newValue = it
                            currentSleep.value = newValue
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier) {
                        Button(
                            onClick = { sleepDialog.value = false }
                        ) {
                            Text("Cancel")
                        }
                        Spacer(modifier = Modifier.size(53.dp))
                        Button(
                            onClick = { sleepDialog.value = false }
                        ) {
                            Text("Save")
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun WalkDialog(walkDialog: MutableState<Boolean>, currentWalk: MutableState<Int>) {
    if (walkDialog.value) {
        Dialog(onDismissRequest = { walkDialog.value = false }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f) // Adjust width as needed
                    .background(color = Color.Transparent)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Edit Walking Amount", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = currentWalk.value.toString(), // Convert double to String
                        onValueChange = {
                            val newValue = it.toIntOrNull() ?: return@TextField // Handle invalid input
                            currentWalk.value = newValue
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        label = { Text("Liters") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier) {
                        Button(
                            onClick = { walkDialog.value = false }
                        ) {
                            Text("Cancel")
                        }
                        Spacer(modifier = Modifier.size(53.dp))
                        Button(
                            onClick = { walkDialog.value = false }
                        ) {
                            Text("Save")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WaterDialog (waterDialog: MutableState<Boolean>, currentLiters: MutableState<Double>) {
    if (waterDialog.value) {
        Dialog(onDismissRequest = { waterDialog.value = false }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f) // Adjust width as needed
                    .background(color = Color.Transparent)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Edit Liters", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = currentLiters.value.toString(), // Convert double to String
                        onValueChange = {
                            val newValue = it.toDoubleOrNull() ?: return@TextField // Handle invalid input
                            currentLiters.value = newValue
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        label = { Text("Liters") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier) {
                        Button(
                            onClick = { waterDialog.value = false }
                        ) {
                            Text("Cancel")
                        }
                        Spacer(modifier = Modifier.size(53.dp))
                        Button(
                            onClick = { waterDialog.value = false }
                        ) {
                            Text("Save")
                        }
                    }
                }
            }
        }
    }
}


