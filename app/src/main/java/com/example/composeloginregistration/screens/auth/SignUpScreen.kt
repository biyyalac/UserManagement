package com.example.composeloginregistration.screens.auth

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeloginregistration.navigation.AppRouter
import com.example.composeloginregistration.navigation.Screen
import com.example.composeloginregistration.components.CheckBoxComponent
import com.example.composeloginregistration.components.ClickBleAlreadyHaveAccount
import com.example.composeloginregistration.components.DividerComponent
import com.example.composeloginregistration.components.HeaderTextComponent
import com.example.composeloginregistration.components.LoginButtonComponent
import com.example.composeloginregistration.components.MyTextField
import com.example.composeloginregistration.components.NormalTextComponent
import com.example.composeloginregistration.components.PasswordTextField
import com.example.composeloginregistration.screens.auth.viewmodel.AuthenticationViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Preview
@Composable
fun SignUpScreen(authenticationViewModel: AuthenticationViewModel = viewModel(factory = AppViewModelProvider.factory)){
    val coroutineScope= rememberCoroutineScope()
    val ctxt= LocalContext.current

   /* val ctxt= LocalContext.current
   
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var userEntity=authenticationViewModel.userInputState.userEntity*/
    var userEntity=authenticationViewModel.userInputState.userEntity
    LaunchedEffect(key1 = ctxt) {
        authenticationViewModel.responseHandler.collect{

            if(it.resCode==200)
            {
                AppRouter.navigateTo(Screen.signinScreen)
            }
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp)
    ) {
        Box {
            Column {
                Spacer(modifier = Modifier.heightIn(20.dp))
                NormalTextComponent("Hey, There")
                HeaderTextComponent("Signup Here")
                Spacer(modifier = Modifier.heightIn(20.dp))
                MyTextField(
                    "Enter First Name",
                    onTextChange = {
                        userEntity.fname = it
                        authenticationViewModel.updateUserInput(userEntity)
                        //Log.e("Database Not create","Database Not create fname $it");
                        // Toast.makeText(ctxt, it, Toast.LENGTH_SHORT).show()
                    },
                    Icons.Outlined.AccountCircle
                )

                MyTextField(
                    "Enter Last Name",
                    onTextChange = {
                        userEntity.lname = it
                        authenticationViewModel.updateUserInput(userEntity)
                        // Log.e("Database Not create","Database Not create lname $it");
                        // Toast.makeText(ctxt, it, Toast.LENGTH_SHORT).show()
                    },
                    Icons.Outlined.AccountCircle
                )
                MyTextField(
                    "Enter Email",
                    onTextChange = {
                        //  Log.e("Database Not create","Database Not create 1 $it");
                        userEntity.email = it
                        authenticationViewModel.updateUserInput(userEntity)
                        // Log.e("Database Not create","Database Not create 2 $it");
                        // Toast.makeText(ctxt, it, Toast.LENGTH_SHORT).show()
                    },
                    Icons.Outlined.Email
                )

                PasswordTextField(
                    "Enter Password",
                    onTextChange = {
                        userEntity.password = it
                        authenticationViewModel.updateUserInput(userEntity)
                        // Log.e("Database Not create","Database Not create password $it");
                        // Toast.makeText(ctxt, it, Toast.LENGTH_SHORT).show()
                    },
                    Icons.Outlined.Lock

                )
                Spacer(modifier = Modifier.heightIn(12.dp))
                CheckBoxComponent(onTextClicked = {
                    AppRouter.navigateTo(Screen.termsAndConditionsScreen)
                })
                Spacer(modifier = Modifier.heightIn(80.dp))
                LoginButtonComponent("Sign Up", onclicked = {
                    coroutineScope.launch(Dispatchers.IO) {
                        authenticationViewModel.insertUser(userEntity)
                    }
                })
                Spacer(modifier = Modifier.heightIn(10.dp))

                ClickBleAlreadyHaveAccount(onTextClicked = {
                    AppRouter.navigateTo(Screen.signinScreen)
                })

                DividerComponent()


            }
        }
    }
}

@Composable
fun SimpleSnackbar(show: Boolean, dismiss: () -> Unit) {
    Snackbar(content = {
        Text(text = "Snackbar")
    }, modifier = Modifier
        .padding(horizontal = 16.dp)
        , action = {
        Text(text = "Dismiss", modifier = Modifier.clickable(onClick = {
            dismiss()
        }))
    })
}