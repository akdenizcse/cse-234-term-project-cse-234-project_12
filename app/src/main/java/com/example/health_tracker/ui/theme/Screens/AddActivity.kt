package com.example.health_tracker.ui.theme.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
    }
}