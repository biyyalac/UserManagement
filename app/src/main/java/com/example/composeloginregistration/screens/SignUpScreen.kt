package com.example.composeloginregistration.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeloginregistration.navigation.AppRouter
import com.example.composeloginregistration.navigation.Screen
import com.example.composeloginregistration.components.CheckBoxComponent
import com.example.composeloginregistration.components.DividerComponent
import com.example.composeloginregistration.components.HeaderTextComponent
import com.example.composeloginregistration.components.LoginButtonComponent
import com.example.composeloginregistration.components.MyTextField
import com.example.composeloginregistration.components.NormalTextComponent
import com.example.composeloginregistration.components.PasswordTextField

@Preview
@Composable
fun SignUpScreen(){
    val ctxt= LocalContext.current
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
                        Toast.makeText(ctxt, it, Toast.LENGTH_SHORT).show()
                    },
                    Icons.Outlined.AccountCircle
                )

                MyTextField(
                    "Enter Last Name",
                    onTextChange = {
                        Toast.makeText(ctxt, it, Toast.LENGTH_SHORT).show()
                    },
                    Icons.Outlined.AccountCircle
                )
                MyTextField(
                    "Enter Email",
                    onTextChange = {
                        Toast.makeText(ctxt, it, Toast.LENGTH_SHORT).show()
                    },
                    Icons.Outlined.AccountCircle
                )

                PasswordTextField(
                    "Enter Password",
                    /* onTextChange = {
                         // Toast.makeText(ctxt, it, Toast.LENGTH_SHORT).show()
                     },*/
                    Icons.Outlined.Lock

                )
                Spacer(modifier = Modifier.heightIn(12.dp))
                CheckBoxComponent(onTextClicked = {
                    AppRouter.navigateTo(Screen.termsAndConditionsScreen)
                })
                Spacer(modifier = Modifier.heightIn(80.dp))
                LoginButtonComponent("Login")

                 DividerComponent()


            }
        }
    }
}