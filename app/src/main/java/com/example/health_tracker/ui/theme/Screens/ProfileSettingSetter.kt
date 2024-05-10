package com.example.health_tracker.ui.theme.Screens

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.toColor
import com.example.health_tracker.R

@Preview
@Composable
fun ProfileSettings(){
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

    }
}
