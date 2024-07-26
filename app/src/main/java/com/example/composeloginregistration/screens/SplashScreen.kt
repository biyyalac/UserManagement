package com.example.composeloginregistration.screens

import android.window.SplashScreen
import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeloginregistration.R

@Preview
@Composable
fun SplashScreen(modifier: Modifier = Modifier,valid:Boolean=true) {
    val color = remember { Animatable(Color.Black) }


    LaunchedEffect(key1 = valid) {
        valid?.let { valid ->
            val animateToColor = if (valid) Color.Green else Color.Red
            color.animateTo(animateToColor, animationSpec = tween(500))
        }
    }
    Surface(onClick = {

    }) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color.value),
                modifier = Modifier.size(100.dp),
            )

        }
}
}