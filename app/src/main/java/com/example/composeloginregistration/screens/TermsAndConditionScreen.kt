package com.example.composeloginregistration.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeloginregistration.navigation.AppRouter
import com.example.composeloginregistration.navigation.Screen
import com.example.composeloginregistration.navigation.SystemBackButtonHandler


@Composable
fun TermsAndConditionsScreen() {
    Surface(
        modifier = Modifier.fillMaxSize().
        background(color = Color.White)
            .padding(24.dp)
    ) {

        SystemBackButtonHandler{
            AppRouter.navigateTo(Screen.SignUpScreen)
        }

    }
    
}