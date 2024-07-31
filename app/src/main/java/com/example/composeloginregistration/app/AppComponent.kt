package com.example.composeloginregistration.app

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeloginregistration.navigation.AppRouter
import com.example.composeloginregistration.navigation.Screen
import com.example.composeloginregistration.screens.DashBoardScreen
import com.example.composeloginregistration.screens.GoogleMaps
import com.example.composeloginregistration.screens.auth.SignInScreen
import com.example.composeloginregistration.screens.auth.SignUpScreen
import com.example.composeloginregistration.screens.TermsAndConditionsScreen
import com.example.composeloginregistration.screens.auth.AppViewModelProvider
import com.example.composeloginregistration.screens.auth.viewmodel.AuthenticationViewModel
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppComponent(authenticationViewModel: AuthenticationViewModel) {
    val ctxt= LocalContext.current
    val coroutineScope= rememberCoroutineScope()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = ctxt) {
        authenticationViewModel.responseHandler.collect{
            Log.e("Response Message","Response Message ${it.msg}")

            scope.launch {
                snackbarHostState.showSnackbar(it.msg)
            }
            if(it.resCode==200)
            {
                AppRouter.navigateTo(Screen.signinScreen)
            }else if(it.resCode==202)
            {
                AppRouter.navigateTo(Screen.dashboardScreen)
            }
        }
    }
    Scaffold (
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ){contentPadding->
        Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize().padding(contentPadding)
        ) {
            Crossfade(targetState = AppRouter.currentScreen) {

              /*  if(authenticationViewModel.application.getUserId()?.isNotEmpty() == true)
                {
                    it.value=Screen.dashboardScreen
                }*/

                when (it.value) {
                    is Screen.signUpScreen -> SignUpScreen(authenticationViewModel)
                    is Screen.termsAndConditionsScreen -> TermsAndConditionsScreen()
                    is Screen.signinScreen -> SignInScreen(authenticationViewModel)
                    is Screen.mapsScreen -> GoogleMaps(authenticationViewModel)
                    is Screen.dashboardScreen -> DashBoardScreen(authenticationViewModel)

                }

            }
        }
    }
}