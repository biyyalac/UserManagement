package com.example.composeloginregistration

import android.os.Build
import android.text.format.Time
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeloginregistration.components.NormalTextComponent
import kotlinx.coroutines.delay
import java.util.Calendar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun ClockPreview() {
    fun currentTime(): Time { // 1
        val cal = Calendar.getInstance()
        val timer= Time()
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
    NormalTextComponent("${time.hour}:${time.minute}:${time.second}")

}