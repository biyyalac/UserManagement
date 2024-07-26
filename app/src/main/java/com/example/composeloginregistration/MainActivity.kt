package com.example.composeloginregistration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.composeloginregistration.app.AppComponent
import com.example.composeloginregistration.ui.theme.ComposeLoginRegistrationTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewmodel by viewModels<AppViewModel> ()
       viewmodel.user_id.value= (  ( application)as MyApplication).getUserId().toString()
        installSplashScreen().apply {
            setKeepOnScreenCondition(){
                !viewmodel.isReady.value
            }
        }
        enableEdgeToEdge( SystemBarStyle.light(resources.getColor(R.color.d2),resources.getColor(R.color.red)))

        setContent {
            AppComponent()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeLoginRegistrationTheme {
      //  AppComponent()
    }
}