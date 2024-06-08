package com.example.health_tracker.ui.theme.Screens


import android.graphics.Paint.Align
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.core.graphics.toColor
import com.example.health_tracker.R

@Preview
@Composable
fun ProfileSettings(){
    //Colors
    val gradientColors = listOf(
        colorResource(id = R.color.dark_gray),
        colorResource(id = R.color.light_gray),
        colorResource(id = R.color.light)
    )
    //Background
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = gradientColors)
            )
    ) {
        AllSettings()

    }
}

@Composable
fun AllSettings(){


    val gradientColors = listOf(
        colorResource(id = R.color.dark_gray),
        colorResource(id = R.color.light_gray),
        colorResource(id = R.color.light)
    )
    Column(modifier = Modifier.fillMaxSize()) {
        //Settings Box
        Card(modifier = Modifier
            .padding(top = 60.dp, start = 10.dp)
            .width(370.dp)
            .height(670.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = gradientColors
                ),
                shape = RoundedCornerShape(10.dp)
            ),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.dark_gray)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Box(modifier = Modifier.fillMaxSize()){
                //Top right close button
                Row(modifier = Modifier
                    .align(Alignment.TopEnd)) {
                   // Image(painter = ,
                        //contentDescription ="X button to close window" )
                }
                //Username row
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 55.dp, start = 20.dp)
                        .clickable {

                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.username_column),
                        style = TextStyle(
                            color = colorResource(id = R.color.black),
                            fontSize = 20.sp
                        )
                    )

                }
                //Password row
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 130.dp, start = 20.dp)
                        .clickable {

                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.password_column),
                        style = TextStyle(
                            color = colorResource(id = R.color.black),
                            fontSize = 20.sp
                        )
                    )
                }
                //Name row
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 205.dp, start = 20.dp)
                        .clickable {

                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.name_column),
                        style = TextStyle(
                            color = colorResource(id = R.color.black),
                            fontSize = 20.sp
                        )
                    )
                }
                //Surname row
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 280.dp, start = 20.dp)
                        .clickable {

                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.surname_column),
                        style = TextStyle(
                            color = colorResource(id = R.color.black),
                            fontSize = 20.sp
                        )
                    )
                }
                //Age row
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 355.dp, start = 20.dp)
                        .clickable {

                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.age_column),
                        style = TextStyle(
                            color = colorResource(id = R.color.black),
                            fontSize = 20.sp
                        )
                    )
                }
                //Weight row
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 430.dp, start = 20.dp)
                        .clickable {

                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.weight_column),
                        style = TextStyle(
                            color = colorResource(id = R.color.black),
                            fontSize = 20.sp
                        )
                    )
                }
                //Height row
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 505.dp, start = 20.dp)
                        .clickable {

                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.height_column),
                        style = TextStyle(
                            color = colorResource(id = R.color.black),
                            fontSize = 20.sp
                        )
                    )
                }
                //Goal row
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 580.dp, start = 20.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.goal_column),
                        style = TextStyle(
                            color = colorResource(id = R.color.black),
                            fontSize = 20.sp
                        )
                    )
                }
            }
        }
    }


}

@Composable
fun UsernamePopUp(usernamePopup: MutableState<Boolean>, currentUsername: MutableState<String>){
    if(usernamePopup.value){
        Dialog(onDismissRequest = { usernamePopup.value = false}) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(color = Color.Transparent)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Edit Username",
                        style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = currentUsername.value.toString(),
                        onValueChange = {
                            val newValue = it
                            currentUsername.value = newValue
                        })

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier){
                        Button(onClick = { usernamePopup.value = false}) {
                            Text(text = "Cancel")
                        }

                        Spacer(modifier = Modifier.size(53.dp))

                        Button(onClick = {usernamePopup.value = false}) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}
