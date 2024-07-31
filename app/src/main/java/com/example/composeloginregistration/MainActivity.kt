package com.example.composeloginregistration

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeloginregistration.app.AppComponent
import com.example.composeloginregistration.screens.auth.AppViewModelProvider
import com.example.composeloginregistration.screens.auth.viewmodel.AuthenticationViewModel
import com.example.composeloginregistration.ui.theme.ComposeLoginRegistrationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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
            val scope = rememberCoroutineScope()
            val authenticationViewModel: AuthenticationViewModel = viewModel(factory = AppViewModelProvider.factory)
            LaunchedEffect(key1 = LocalContext.current) {
                scope.launch {
                    authenticationViewModel.checkUser(viewmodel.user_id.value)
                }
            }


            AppComponent(authenticationViewModel)
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