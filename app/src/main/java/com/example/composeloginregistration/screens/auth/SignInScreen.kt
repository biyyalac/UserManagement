package com.example.composeloginregistration.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeloginregistration.components.ClickBleDontHaveText
import com.example.composeloginregistration.components.HeaderTextComponent
import com.example.composeloginregistration.components.LoginButtonComponent
import com.example.composeloginregistration.components.MyTextField
import com.example.composeloginregistration.components.NormalTextComponent
import com.example.composeloginregistration.components.PasswordTextField
import com.example.composeloginregistration.navigation.AppRouter
import com.example.composeloginregistration.navigation.Screen
import com.example.composeloginregistration.screens.auth.viewmodel.AuthenticationViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun SignInScreen(authenticationViewModel: AuthenticationViewModel = viewModel(factory = AppViewModelProvider.factory)) {
    val coroutineScope= rememberCoroutineScope()
    val ctxt= LocalContext.current
    LaunchedEffect(key1 = ctxt) {
        authenticationViewModel.responseHandler.collect{

            if(it.resCode==200)
            {
                AppRouter.navigateTo(Screen.dashboardScreen)
            }
        }
    }
    var email =remember   {""
    }
    var password =remember   {""
    }
    Surface(onClick = { }, modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(24.dp)) {
        Column {
            Spacer(modifier = Modifier.heightIn(30.dp))
            NormalTextComponent("Hey There")
            HeaderTextComponent("Signing Here")
            Spacer(modifier = Modifier.heightIn(80.dp))
            MyTextField(placeholder = "Enter Email Id", onTextChange = {
                email=it
            }, leadingIcon = Icons.Filled.Email)
            PasswordTextField(placeholder = "Enter Email Id", onTextChange = {password=it}, leadingIcon = Icons.Filled.Lock)
            Spacer(modifier = Modifier.heightIn(80.dp))
            LoginButtonComponent("Sign In", onclicked ={
                coroutineScope.launch(Dispatchers.IO) {

                   authenticationViewModel.checkUser(email = email, password = password)

                }

            })
            Spacer(modifier = Modifier.heightIn(10.dp))

            ClickBleDontHaveText(onTextClicked = {
                AppRouter.navigateTo(Screen.signUpScreen)
            })
        }
    }

}

@Preview
@Composable
private fun SiginPreview() {
    SignInScreen()
}