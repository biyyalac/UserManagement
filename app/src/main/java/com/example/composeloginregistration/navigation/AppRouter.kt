package com.example.composeloginregistration.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    object signUpScreen: Screen()
    object termsAndConditionsScreen: Screen()
    object signinScreen: Screen()
    object dashboardScreen: Screen()
    object mapsScreen: Screen()
}

object AppRouter{
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.signinScreen)
    fun navigateTo(destination: Screen){
        currentScreen.value=destination
    }

}