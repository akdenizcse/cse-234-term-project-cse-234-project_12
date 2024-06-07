package com.example.health_tracker.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
fun LoginForm(
    onLoginButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {},
    onForgetPasswordClicked: () -> Unit = {},
    onContactUsClicked: () -> Unit = {}

    //TODO should we pass the modifier
) {
    //Temporary Values For Holding The UI

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    //Gradient Colors
    val colors1 = listOf(Color(0xFFFFEBD4), Color(0xFFFCE0D7), Color(0xFFFFFDC5))
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
            painter = painterResource(id = R.drawable.icons),
            contentDescription = "App Icon"
        )
        Text(
            text = stringResource(id = R.string.app_name),
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
            text = stringResource(id = R.string.mission_statement),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF000000),
                letterSpacing = 0.14.sp,
            ),
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            leadingIcon = { Icon(Icons.Default.Person, null) },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .width(300.dp)
                .height(50.dp)
                .shadow(15.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 16.dp))
                .align(alignment = Alignment.CenterHorizontally),
            placeholder = {
                Text(text = stringResource(id = R.string.username), color = Color.Black
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = { Icon(Icons.Default.Lock, null) },
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
                    text = stringResource(id = R.string.password),
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = onLoginButtonClicked,
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .width(220.dp)
                .height(36.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 30.dp))
                .align(alignment = Alignment.CenterHorizontally)
                .border(
                    width = 1.dp,
                    color = Color(0xFF000000),
                    shape = RoundedCornerShape(size = 30.dp)
                )
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color(0x4D000000),
                    ambientColor = Color(0x4D000000),
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Text(
                text = stringResource(id = R.string.login),
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            Text(
                text = stringResource(id = R.string.do_not_account),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily.Default,
                    color = Color(0xFF000000),
                    letterSpacing = 0.1.sp,
                )
            )
            Text(text = stringResource(id = R.string.sign_up_now),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF000000),
                    letterSpacing = 0.1.sp,
                ),
                modifier = Modifier.clickable {
                    onSignUpButtonClicked()
                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.forget_password),
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily.Default,
                color = Color(0xFF000000),
                letterSpacing = 0.1.sp,
            ),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    onForgetPasswordClicked()
                }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = stringResource(id = R.string.contact_for_support),
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
                    onContactUsClicked()
                }

        )
    }
}
