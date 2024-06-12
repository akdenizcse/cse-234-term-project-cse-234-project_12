package com.example.health_tracker.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
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
fun AddActivityScreen(){
    val gradientColors = listOf(Color(0xFFFFEBD4), Color(0xFFFCE0D7), Color(0xFFFFFDC5))

    var searchText by remember { mutableStateOf("") }
    var titleText by remember { mutableStateOf("") }
    var isMonday by remember { mutableStateOf(false) }
    var isFriday by remember { mutableStateOf(false) }
    var isSaturday by remember { mutableStateOf(false) }
    var isSunday by remember { mutableStateOf(false) }
    var isTuesday by remember { mutableStateOf(false) }
    var isThursday by remember { mutableStateOf(false) }
    var isWednesday by remember { mutableStateOf(false) }
    var savedItems by remember {mutableStateOf(emptyList<Item>())}
    val exercises = listOf(
        "Arnold Press",
        "Back Extention",
        "Barbell Bench Press",
        "Barbell Biceps Curl",
        "Cable Fly",
        "Deadlift",
        "Dumbell Fly",
        "Barbell bent-over row",
        "Barbell shoulder press",
        "Barbell shrug",
        "Cable lateral raise",
        "Cable pull-down",
        "Chest fly",
        "Chin up",
        "Close-grip pull-up",
        "Crunch",
        "Decline bench press",
        "Diamond push-up",
        "Dumbell bench press",
        "Dumbell biceps curl",
        "Dumbell bent-over row",
        "Dumbell lateral raise",
        "Dumbell shoulder press",
        "Dumbell shrug",
        "Good morning",
        "Hanging leg raise",
        "Hyperextension",
        "Incline bench press",
        "Lat pull-down",
        "Leg curl",
        "Leg extension",
        "Leg press",
        "Leg raise",
        "Lunge",
        "Narrow-grip push-up",
        "Neck curl",
        "Overhead triceps extension",
        "Preacher curl",
        "Pull-down",
        "Pull-up",
        "Push-up",
        "Reverse grip pull-down",
        "Reverse grip push-down",
        "Roman chair leg raise",
        "Romanian deadlift",
        "Russian twist",
        "Seated calf raise",
        "Shoulder shrug",
        "Squat",
        "Standing calf raise",
        "T-bar row",
        "Triceps dip",
        "Triceps extension",
        "Triceps push-down",
        "Upright row",
        "Weighted Russian twist",
        "Wide-grip pull-up",
        "Wide-grip push-up"
    )

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
                .padding(start = 55.dp, top = 40.dp)
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
            placeholder = { Text("Search") },
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
        Spacer(modifier = Modifier.height(20.dp))
        //Title textfield
        TextField(value = titleText,
            onValueChange = {titleText = it},
            modifier = Modifier
                .padding(start = 55.dp)
                .background(
                    color = Color.Transparent
                )
                .width(300.dp),
                placeholder = {Text("Title (Optional)")},
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.LightGray.copy(alpha = 0.5f), // Semi-transparent
                focusedIndicatorColor = Color.Gray.copy(alpha = 0.8f), // More opaque
                focusedContainerColor = Color.White.copy(alpha = 0.9f), // Slightly transparent
                unfocusedContainerColor = Color.White.copy(alpha = 0.5f) // Fully opaque
            ))
        Spacer(modifier = Modifier.height(20.dp))
        //Days
        Text(
            text = "Days",
            style = TextStyle(
                fontSize = 30.sp
            ),
            modifier = Modifier.padding(start = 40.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        //1st row
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Monday",
                style = TextStyle(
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(start = 40.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Checkbox(checked = isMonday,
                onCheckedChange ={isMonday = it},
                modifier = Modifier
                    .size(30.dp),
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFC8E3ED),
                    uncheckedColor = Color(0xFFC8E3ED),
                    checkmarkColor = Color.Black
                ))
            Spacer(modifier = Modifier.width(110.dp))
            Text(text = "Friday",
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.width(5.dp))
            Checkbox(checked = isFriday,
                onCheckedChange ={isFriday = it},
                modifier = Modifier
                    .size(30.dp),
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFC8E3ED),
                    uncheckedColor = Color(0xFFC8E3ED),
                    checkmarkColor = Color.Black
                ))
        }
        Spacer(modifier = Modifier.height(20.dp))
        //2nd row
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Tuesday",
                style = TextStyle(
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(start = 40.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Checkbox(checked = isTuesday,
                onCheckedChange ={isTuesday = it},
                modifier = Modifier
                    .size(30.dp),
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFC8E3ED),
                    uncheckedColor = Color(0xFFC8E3ED),
                    checkmarkColor = Color.Black
                ))
            Spacer(modifier = Modifier.width(100.dp))
            Text(text = "Saturday",
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.width(5.dp))
            Checkbox(checked = isSaturday,
                onCheckedChange ={isSaturday = it},
                modifier = Modifier
                    .size(30.dp),
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFC8E3ED),
                    uncheckedColor = Color(0xFFC8E3ED),
                    checkmarkColor = Color.Black
                ))
        }
        Spacer(modifier = Modifier.height(20.dp))
        //3rd row
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Wednesday",
                style = TextStyle(
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(start = 40.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Checkbox(checked = isWednesday,
                onCheckedChange ={isWednesday = it},
                modifier = Modifier
                    .size(30.dp),
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFC8E3ED),
                    uncheckedColor = Color(0xFFC8E3ED),
                    checkmarkColor = Color.Black
                ))
            Spacer(modifier = Modifier.width(70.dp))
            Text(text = "Sunday",
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.width(5.dp))
            Checkbox(checked = isSunday,
                onCheckedChange ={isSunday = it},
                modifier = Modifier
                    .size(30.dp),
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFC8E3ED),
                    uncheckedColor = Color(0xFFC8E3ED),
                    checkmarkColor = Color.Black
                ))
        }
        Spacer(modifier = Modifier.height(20.dp))
        //4th row
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Thursday",
                style = TextStyle(
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(start = 40.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Checkbox(checked = isThursday,
                onCheckedChange ={isThursday = it},
                modifier = Modifier
                    .size(30.dp),
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFC8E3ED),
                    uncheckedColor = Color(0xFFC8E3ED),
                    checkmarkColor = Color.Black
                ))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Exercise",
            style = TextStyle(
                fontSize = 30.sp
            ),
            modifier = Modifier.padding(start = 40.dp))
        
        //Exercise list
        Checklist(items = exercises)

        //Buttons
        Column(
            modifier = Modifier
                .padding(start = 200.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            //Turn Back Button
            Button(onClick = { /*TODO*/ },
                colors = ButtonColors(
                    containerColor = Color(0xFFC8E3ED),
                    contentColor = Color.Black,
                    disabledContainerColor = Color(0xFFC8E3ED),
                    disabledContentColor = Color.Black),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                modifier = Modifier

            ) {
                Text(
                    text = "Turn Back",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Image(painter = painterResource(id = R.drawable.turn_back_1),
                    contentDescription ="Turn Back icon" ,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(15.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            //Save Button
            Button(onClick = {

            },
                colors = ButtonColors(
                    containerColor = Color(0xFFC8E3ED),
                    contentColor = Color.Black,
                    disabledContainerColor = Color(0xFFC8E3ED),
                    disabledContentColor = Color.Black),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                modifier = Modifier
                    .padding(start = 35.dp)

            ) {
                Text(
                    text = "Save",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Image(painter = painterResource(id = R.drawable.diskette_1),
                    contentDescription ="Save diskette icon",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(15.dp))
            }
        }

    }
}
//Exercise List maker function
@Composable
fun Checklist(items: List<String>) {
    val checkedStates = remember { mutableStateListOf(*items.map { false }.toTypedArray()) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(items.size) { index ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 35.dp, top = 20.dp)
            ) {
                Text(
                    text = items[index],
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.padding(start = 8.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Checkbox(
                    checked = checkedStates[index],
                    modifier = Modifier
                        .size(30.dp),
                    enabled = true,
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFC8E3ED),
                        uncheckedColor = Color(0xFFC8E3ED),
                        checkmarkColor = Color.Black
                    ),
                    onCheckedChange = { checked ->
                        checkedStates[index] = checked
                    }
                )
            }
        }
    }
}