package com.example.composeloginregistration.screens

import android.os.Build
import android.text.format.Time
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeloginregistration.R
import com.example.composeloginregistration.components.HeaderTextComponent
import com.example.composeloginregistration.components.NormalTextComponent
import com.example.composeloginregistration.screens.auth.AppViewModelProvider
import com.example.composeloginregistration.screens.auth.viewmodel.AuthenticationViewModel
import kotlinx.coroutines.delay
import java.time.Clock
import java.util.Calendar


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashBoardScreen(authenticationViewModel: AuthenticationViewModel = viewModel(factory = AppViewModelProvider.factory)) {

    Scaffold (topBar = {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                Brush.linearGradient(listOf(Color.Blue, Color.Red)),
            ), contentAlignment = Alignment.Center,){
            HeaderTextComponent("DashBoard",Color.White)
        }
    }){contentPadding->
        Surface(onClick = {}, modifier = Modifier
            .background(Color.White)
            .padding(contentPadding)
            .padding(24.dp)) {
            Column {
                ClockPreview()
                DashboardPreview()
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun ClockPreview() {
    fun currentTime(): Time { // 1
        val cal = Calendar.getInstance()
        val timer=Time()
        timer.set(cal.timeInMillis)
        return timer
    }

    var time by remember { mutableStateOf(currentTime()) } // 2
    LaunchedEffect(0) { // 3
        while (true) {
            time = currentTime()
            delay(1000)
        }
    }
    Row (horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()){
        NormalTextComponent("${time.monthDay}:0${time.month}:${time.year} - ${time.hour}:${time.minute}:${time.second}")
    }

}
@Preview
@Composable
private fun DashboardPreview() {

    Column {
        Row (modifier = Modifier.padding(20.dp)){
            Card(modifier = Modifier.padding(10.dp)) {
                Column(verticalArrangement = Arrangement.Center,modifier = Modifier
                    .requiredWidth(120.dp)
                    .heightIn(120.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.icon_location),"")
                    NormalTextComponent("Location")
                }
            }
            Card(modifier = Modifier.padding(10.dp)) {
                Column(verticalArrangement = Arrangement.Center,modifier = Modifier
                    .requiredWidth(120.dp)
                    .heightIn(120.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.icon_notes),"")
                    NormalTextComponent("My Notes")
                }
            }
        }
    }
}