package com.example.health_tracker.ui.theme.Screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.health_tracker.R

@Preview(showBackground = true)
@Composable
fun SignUp() {
    //Temporary Values For Holding The UI
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    //Gradient Colors
    val colors1 = listOf(Color(0xFF979797), Color(0xFFDDD7D7), Color(0xFFF4F4F4))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                brush = Brush.verticalGradient(colors = colors1)
            ), verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .width(209.48944.dp)
                .height(200.73366.dp)
                .align(alignment = Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "App Icon"
        )
        Text(
            text = "Solstice",
            style = TextStyle(
                fontSize = 32.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(800),
                color = Color(0xFF000000),
                letterSpacing = 0.32.sp,
            ),
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Always Help You Track Your Health",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF000000),
                letterSpacing = 0.14.sp,
            ),
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(60.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            leadingIcon = { Icon(Icons.Default.Person, null) },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .width(300.dp)
                .height(50.dp)
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color(0x4D000000),
                    ambientColor = Color(0x4D000000),
                    shape = RoundedCornerShape(10.dp)
                )
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color(0x26000000),
                    ambientColor = Color(0x26000000),
                    shape = RoundedCornerShape(10.dp)
                )
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 16.dp))
                .align(alignment = Alignment.CenterHorizontally),
            placeholder = {
                Text(
                    "Username",
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(35.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            shape = RoundedCornerShape(15.dp),
            leadingIcon = { Icon(Icons.Default.Lock, null) },
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .width(300.dp)
                .height(50.dp)
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color(0x4D000000),
                    ambientColor = Color(0x4D000000),
                    shape = RoundedCornerShape(10.dp)
                )
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color(0x26000000),
                    ambientColor = Color(0x26000000),
                    shape = RoundedCornerShape(10.dp)
                )
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 16.dp))
                .align(alignment = Alignment.CenterHorizontally),
            placeholder = {
                Text(
                    "Password",
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(35.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email =it },
            leadingIcon = { Icon(Icons.Default.Email, null) },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .width(300.dp)
                .height(50.dp)
                .shadow(15.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 16.dp))
                .align(alignment = Alignment.CenterHorizontally),
            placeholder = {
                Text(
                    "email", color = Color.Black
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .width(220.dp)
                .height(36.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 30.dp))
                .align(alignment = Alignment.CenterHorizontally),
        ) {
            Text(
                text = "LOGIN",
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            Text(
                text = "Already have an account? ",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily.Default,
                    color = Color(0xFF000000),
                    letterSpacing = 0.1.sp,
                )
            )

            Text(text = "Log In Now",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF000000),
                    letterSpacing = 0.1.sp,
                ),
                modifier = Modifier.clickable {

                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Contact For Support",
            style = TextStyle(
                fontSize = 10.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily.Default,
                color = Color(0xFF000000),
                letterSpacing = 0.1.sp,
            ),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {

                }

        )
    }
}


@Composable
fun EditNumberField(
    @StringRes label : Int,
    @DrawableRes leadingIcon: Int,
    value: String,
    keyboardOptions: KeyboardOptions,
    onValueChanged: (String) -> Unit,
    modifier: Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange =onValueChanged,
        shape = RoundedCornerShape(15.dp),
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon),null ) },
        modifier = modifier,
        label = { Text(stringResource(id = label)) },
        keyboardOptions = keyboardOptions
    )
}