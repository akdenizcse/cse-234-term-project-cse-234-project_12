package com.example.health_tracker.ui.theme.Screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.health_tracker.HealthTrackerScreen
import com.example.health_tracker.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun ForgotPassword(
    navController: NavController
) {
    //Temporary Values For Holding The UI

    var email by remember { mutableStateOf("") }
    var firebase: Firebase by remember { mutableStateOf(Firebase) }

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

        Spacer(modifier = Modifier.height(35.dp))

        Column(
            Modifier
                .width(300.dp)
                .height(200.dp)
                .background(color = Color(0xFFFFFFFF))
                .align(Alignment.CenterHorizontally)
                .border(
                    shape = RoundedCornerShape(5.dp),
                    border = ButtonDefaults.outlinedButtonBorder
                )
                .background(
                    color = Color.White
                )

        )
        {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.forget_password),
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    letterSpacing = 0.2.sp,
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)

            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {

                Text(
                    text = stringResource(id = R.string.pw_remember),
                    style = TextStyle(
                        fontSize = 13.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        letterSpacing = 0.13.sp,
                    )
                )

                Text(text = stringResource(id = R.string.f_p_log_in),
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000),
                        letterSpacing = 0.1.sp,
                    ),
                    modifier = Modifier.clickable {
                        navController.navigate(HealthTrackerScreen.Login.name)
                    }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                leadingIcon = { Icon(Icons.Default.Email, null) },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(250.dp)
                    .height(50.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 16.dp))
                    .align(alignment = Alignment.CenterHorizontally),
                placeholder = {
                    Text(
                        stringResource(id = R.string.e_mail), color = Color.Black
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                )

            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedButton(
                onClick = {
                          firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                              if (task.isSuccessful) {
                                  Toast.makeText(
                                      navController.context,
                                      "Email sent successfully if it exists :)",
                                      Toast.LENGTH_SHORT
                                  ).show()
                              }
                          }
                },
                // TODO: we will send a mail to user
                border = BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .width(150.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
            ) {
                Text(text = stringResource(id = R.string.reset_password_button))

                //shouldn't be send ?
            }

        }


    }
}
