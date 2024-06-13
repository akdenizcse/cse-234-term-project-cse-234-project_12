package com.example.health_tracker.ui.theme.Screens

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.health_tracker.HealthTrackerScreen
import com.example.health_tracker.MainPart
import com.example.health_tracker.R
import com.example.health_tracker.data.ActivityViewModel
import com.example.health_tracker.database.ActivityEntity
import kotlinx.coroutines.launch


@SuppressLint("MutableCollectionMutableState")
@Composable
fun AddActivityScreen(
    navController: NavController,
    activityViewModel: ActivityViewModel
){

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
    var savedExercise by remember { mutableStateOf(emptyList<String>()) }
    var savedDays by remember { mutableStateOf(mutableListOf<String>()) }



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(gradientColors)
            )
    ) {

        Spacer(modifier = Modifier.height(20.dp))
        //Title textfield
        TextField(value = titleText,
            onValueChange = {titleText = it},
            modifier = Modifier
                .padding(start = 55.dp, top = 60.dp)
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
                onCheckedChange ={
                    isMonday = it
                    savedDays.add("Monday")
                                 },
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
                onCheckedChange ={
                    isFriday = it
                    savedDays.add("Friday")

                },
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
                onCheckedChange ={
                    isTuesday = it
                    savedDays.add("Tuesday")
                                 },
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
                onCheckedChange ={
                    isSaturday = it
                    savedDays.add("Saturday")
                                 },
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
                onCheckedChange ={
                    isWednesday = it
                    savedDays.add("Wednesday")
                                 },
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
                onCheckedChange ={
                    isSunday = it
                    savedDays.add("Sunday")
                                 },
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
                onCheckedChange ={
                    isThursday = it
                    savedDays.add("Thursday")
                                 },
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
        Checklist(items = exercises,{checkedItems -> savedExercise = checkedItems},title = titleText,activityViewModel = activityViewModel,savedDays = savedDays)

        //Buttons
        Column(
            modifier = Modifier
                .padding(start = 200.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            //Turn Back Button
            Button(onClick = { navController.navigate(HealthTrackerScreen.Main.name) },
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

        }

    }
}

//Exercise List maker function
@SuppressLint("MutableCollectionMutableState")
@Composable
fun Checklist(
    items: List<String>,
    onCheckedItemsSaved: (List<String>) -> Unit,
    title: String = "Exercise",
    activityViewModel: ActivityViewModel,
    savedDays: MutableList<String>

) {
    var checkedList by remember { mutableStateOf(mutableListOf<String>()) }
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
                        checkedList.add(items[index])
                    }
                )
            }
        }
    }


    Spacer(modifier = Modifier.height(20.dp))
    fun ToastMessage(context: Context){
        Toast.makeText(context, "No items selected to save", Toast.LENGTH_LONG).show()
    }
    val context = LocalContext.current

    Button(
        onClick = {
            val checkedItems = items.filterIndexed { index, _ -> checkedStates[index] }
            if (checkedItems.isNotEmpty()) {
                onCheckedItemsSaved(checkedItems)
                val activityEntity = ActivityEntity(
                    id = 0, // Room will auto-generate the id
                    title = title,
                    savedDays = savedDays.toList(),
                    checkedItems = checkedItems
                )
                activityViewModel.viewModelScope.launch {
                    activityViewModel.addActivity(activityEntity)
                }
                Toast.makeText(context, "Saved", Toast.LENGTH_LONG).show()
            } else {
                ToastMessage(context = context)
            }
        },
        colors = ButtonColors(
                    containerColor = Color(0xFFC8E3ED),
                    contentColor = Color.Black,
                    disabledContainerColor = Color(0xFFC8E3ED),
                    disabledContentColor = Color.Black),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                modifier = Modifier
                    .padding(start = 260.dp)){
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
    "Wide-grip push-up",
    "Wrist curl",
    "Wrist extension",
    "Zottman curl",
    "Zottman preacher curl",
    "Jumping jacks",
    "Burpees",
    "Mountain climbers",
    "High knees",
    "Jumping rope",
    "Box jumps",
    "Sprinting",
    "Stair climbing",
    "Swimming",
    "Cycling",
    "Running",
    "Dancing",
    "Hiking",
    "Tennis",
    "Basketball",
    "Yoga",
    "Pilates",
    "Plank variations",
    "Dips" ,
    "Lunges",
    "Squats",
    "Push-ups",
    "Wall sits",
    "Glute bridges",
    "Lunges with overhead press",
    "Squats with overhead press",
    "Foam rolling",
    "Static stretches",
    "Yoga poses",
    "Seated cable row",
    "Face pull",
    "L-sit pull-up",
    "Archer pull-up",
    "Inverted row",
    "Glute-ham raise",
    "Calf raise machine",
    "Seated Arnold press",
    "Hammer curl",
    "Seated calf raise",
    "Lateral raise to front raise",
    "Russian twist with medicine ball",
    "Ab wheel rollout",
    "Pallof press",
    "Glute bridge with single leg raise",
    "Side plank with hip dip",
    "Spiderman push-up",
    "Bulgarian split squat with dumbbells",
    "Donkey kick",
    "Jump rope",
    "Battle ropes",
    "Kettlebell swings",
    "Elliptical trainer",
    "Turkish get-up",
    "Farmer's walk",
)