package com.example.composeloginregistration.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composeloginregistration.navigation.AppRouter
import com.example.composeloginregistration.navigation.Screen
import com.example.composeloginregistration.screens.SignUpScreen
import com.example.composeloginregistration.screens.TermsAndConditionsScreen

@Composable
fun AppComponent(){
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        Crossfade(targetState = AppRouter.currentScreen) {
            when (it.value) {
                is Screen.SignUpScreen -> SignUpScreen()
                is Screen.termsAndConditionsScreen -> TermsAndConditionsScreen()
        }

    }
}
}