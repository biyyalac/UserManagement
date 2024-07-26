package com.example.composeloginregistration.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeloginregistration.components.HeaderTextComponent
import com.example.composeloginregistration.screens.auth.AppViewModelProvider
import com.example.composeloginregistration.screens.auth.viewmodel.AuthenticationViewModel

@Preview
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

        }
    }

}
@Preview
@Composable
private fun DashboardPreview() {
    
}