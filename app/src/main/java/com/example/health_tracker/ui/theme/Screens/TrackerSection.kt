package com.example.health_tracker.ui.theme.Screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
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
fun TrackerSection() {
    val medications = remember { mutableStateListOf<String>() }
    val colors1 = listOf(Color(0xFF979797), Color(0xFFDDD7D7), Color(0xFFF4F4F4))
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
    if (medicationDialog.value) {
        RecordMedication(medicationDialog, medications)
    }



    Column {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            item {
                MeditationRemainder()
            }

            item {
                TotalWalk()
            }

            item {
                HydrationRemainder()
            }

            item {
                Meditations()
            }

        }
    }
}


@Composable
fun MeditationRemainder() {
    Card(
        modifier = Modifier
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = 1.dp,
                        color = Color(0xFFD1FAD2),
                        shape = RoundedCornerShape(10.dp)
                    ),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.Start),
                    text = "Medications Oncoming",
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color(0xFF000000),
                        letterSpacing = 0.2.sp,
                    )
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = 1.dp,
                        color = Color(0xFFD1FAD2),
                        shape = RoundedCornerShape(10.dp)
                    ),


                ) {
                Image(
                    painter = painterResource(id = R.drawable._859207_capsule_drug_medicine_pill_tablet_icon_1),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size((70.dp))
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = "Lorem Impus",
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                    ),
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterVertically)
                )
            }

        }
    }


}


@Composable
fun TotalWalk() {

    Card(
        modifier = Modifier
            .width(286.dp)
            .height(196.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD1FAD2)
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart) // Position the Column to the top left
                    .padding(10.dp)
            ) {
                Text(
                    text = "Walk",
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color(0xFF000000),
                        letterSpacing = 0.2.sp,
                    )
                )
            }

            Text(
                modifier = Modifier
                    .align(Alignment.Center) // Center the text vertically and horizontally
                    .padding(10.dp),
                text = "Lorem Impus",
                style = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                )
            )
        }
    }
}

@Composable
fun HydrationRemainder() {
    Card(
        modifier = Modifier
            .width(286.dp)
            .height(196.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD1FAD2)
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart) // Position the Column to the top left
                    .padding(10.dp)
            ) {
                Text(
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
            }

            Text(
                modifier = Modifier
                    .align(Alignment.Center) // Center the text vertically and horizontally
                    .padding(10.dp),
                text = "Lorem Impus",
                style = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                )
            )
        }
    }

}

@Composable
fun Meditations() {
    Card(
        modifier = Modifier
            .width(286.dp)
            .height(196.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD1FAD2)
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart) // Position the Column to the top left
                    .padding(10.dp)
            ) {
                Text(
                    text = "Meditations",
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color(0xFF000000),
                        letterSpacing = 0.2.sp,
                    )
                )
            }

            Text(
                modifier = Modifier
                    .align(Alignment.Center) // Center the text vertically and horizontally
                    .padding(10.dp),
                text = "Lorem Impus",
                style = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                )
            )
        }
    }

}


//
//
//@Composable
//fun MeditationRemainder(
//    medicationDialog: MutableState<Boolean>,
//    currentMedications: MutableList<String>
//) {
//    val writtenMedication = remember { mutableStateOf("") }
//    if (medicationDialog.value) {
//        Dialog(onDismissRequest = { medicationDialog.value = false }) {
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth(0.8f) // Adjust width as needed
//                    .background(color = Color.Transparent)
//            ) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text("Update Medication", style = MaterialTheme.typography.bodyMedium)
//                    Spacer(modifier = Modifier.height(16.dp))
//                    TextField(value = writtenMedication.value, onValueChange = {
//                        writtenMedication.value = it
//                        currentMedications.add(it)
//                    })
//                    Row(modifier = Modifier) {
//                        Button(
//                            onClick = { medicationDialog.value = false }
//                        ) {
//                            Text("Cancel")
//                        }
//                        Spacer(modifier = Modifier.size(53.dp))
//                        Button(
//                            onClick = { medicationDialog.value = false }
//                        ) {
//                            Text("Save")
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//}
//
//@Composable
//fun TotalWalk(relaxingDialog: MutableState<Boolean>, currentRelaxing: MutableState<String>) {
//    if (relaxingDialog.value) {
//        Dialog(onDismissRequest = { relaxingDialog.value = false }) {
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth(0.8f) // Adjust width as needed
//                    .background(color = Color.Transparent)
//            ) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text("Edit Relax Time", style = MaterialTheme.typography.bodyMedium)
//                    Spacer(modifier = Modifier.height(8.dp))
//                    TextField(
//                        value = currentRelaxing.value, // Convert double to String
//                        onValueChange = {
//                            val newValue = it
//                            currentRelaxing.value = newValue
//                        },
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Row(modifier = Modifier) {
//                        Button(
//                            onClick = { relaxingDialog.value = false }
//                        ) {
//                            Text("Cancel")
//                        }
//                        Spacer(modifier = Modifier.size(53.dp))
//                        Button(
//                            onClick = { relaxingDialog.value = false }
//                        ) {
//                            Text("Save")
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//}
//
//@Composable
//fun HydrationRemainder(sleepDialog: MutableState<Boolean>, currentSleep: MutableState<String>) {
//    if (sleepDialog.value) {
//        Dialog(onDismissRequest = { sleepDialog.value = false }) {
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth(0.8f) // Adjust width as needed
//                    .background(color = Color.Transparent)
//            ) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text("Edit Sleep Hour", style = MaterialTheme.typography.bodyMedium)
//                    Spacer(modifier = Modifier.height(8.dp))
//                    TextField(
//                        value = currentSleep.value.toString(), // Convert double to String
//                        onValueChange = {
//                            val newValue = it
//                            currentSleep.value = newValue
//                        },
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//
//                        )
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Row(modifier = Modifier) {
//                        Button(
//                            onClick = { sleepDialog.value = false }
//                        ) {
//                            Text("Cancel")
//                        }
//                        Spacer(modifier = Modifier.size(53.dp))
//                        Button(
//                            onClick = { sleepDialog.value = false }
//                        ) {
//                            Text("Save")
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//}
//
//@Composable
//fun Meditations(walkDialog: MutableState<Boolean>, currentWalk: MutableState<Int>) {
//    if (walkDialog.value) {
//        Dialog(onDismissRequest = { walkDialog.value = false }) {
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth(0.8f) // Adjust width as needed
//                    .background(color = Color.Transparent)
//            ) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text("Edit Walking Amount", style = MaterialTheme.typography.bodyMedium)
//                    Spacer(modifier = Modifier.height(8.dp))
//                    TextField(
//                        value = currentWalk.value.toString(), // Convert double to String
//                        onValueChange = {
//                            val newValue =
//                                it.toIntOrNull() ?: return@TextField // Handle invalid input
//                            currentWalk.value = newValue
//                        },
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                        label = { Text("Liters") },
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Row(modifier = Modifier) {
//                        Button(
//                            onClick = { walkDialog.value = false }
//                        ) {
//                            Text("Cancel")
//                        }
//                        Spacer(modifier = Modifier.size(53.dp))
//                        Button(
//                            onClick = { walkDialog.value = false }
//                        ) {
//                            Text("Save")
//                        }
//                    }
//                }
//            }
//        }
//    }
//}




