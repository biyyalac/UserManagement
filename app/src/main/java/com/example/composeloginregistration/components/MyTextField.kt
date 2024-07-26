package com.example.composeloginregistration.components

import android.graphics.drawable.Icon
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyTextField(placeholder: String, onTextChange: (String) -> Unit, leadingIcon: ImageVector) {
    val ctxt= LocalContext.current

    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = {
            onTextChange(it)
            text=it

        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Gray,
            cursorColor = Color.Gray
        ),
        label = { Text(placeholder) },
        leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = "") }

    )
}
@Composable
fun PasswordTextField(placeholder: String, onTextChange: (String) -> Unit, leadingIcon: ImageVector) {
    val ctxt= LocalContext.current

    var text by remember { mutableStateOf("") }
    var icon by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = text,
        onValueChange = {
            text=it
            onTextChange(it)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Gray,
            cursorColor = Color.Gray
        ),
        label = { Text(placeholder) },
        leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = "") },
        trailingIcon = {

            IconButton(onClick = {
                icon=!icon

            }) {
                if (icon)
                    Icon(imageVector = Icons.Outlined.Visibility, contentDescription = "")
                else
                    Icon(imageVector = Icons.Outlined.VisibilityOff, contentDescription = "")

            }
        },
        visualTransformation = if (icon) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(onTextClicked:(String)->Unit) {
    var checked by remember { mutableStateOf(false) }
    Row {
        Checkbox(checked = checked, onCheckedChange = {
            checked=!checked
        })
        ClickBleComponent(onTextClicked)


    }

}

@Composable
fun ClickBleComponent(onTextClicked:(String)->Unit) {
    val initlaText="By continuing you accept our "
    val privacyPolicy="Privacy Policy"
    val and=" and "
    val termsCondition="Termd & Conditions"
    val clickbleText= buildAnnotatedString {
        append(initlaText)
        withStyle(style = SpanStyle(color = Color.DarkGray)){
            pushStringAnnotation(tag = "privacyPolicy", annotation = "privacyPolicy")
            append(privacyPolicy)
        }
        append(and)
        withStyle(style = SpanStyle(color = Color.DarkGray)){
            pushStringAnnotation(tag = "termsCondition", annotation = "termsCondition")
            append(termsCondition)
        }
    }
    ClickableText(text = clickbleText, onClick = {
        clickbleText.getStringAnnotations(it,it).
                firstOrNull()?.also {it->
                    if(it.item=="privacyPolicy"||it.item=="termsCondition")
                     onTextClicked(it.item)

            Log.e("Screen Click","Screen Click ${it.item}")
        }
    })
}
@Preview
@Composable
fun ClickBleDontHaveText(onTextClicked:(String)->Unit= {  }) {
    val initlaText="Don't have account? "
    val signup="SignUp"
    val clickbleText= buildAnnotatedString {
        append(initlaText)
        withStyle(style = SpanStyle(color = Color.DarkGray)){
            pushStringAnnotation(tag = "signup", annotation = "signup")
            append(signup)
        }
    }
    ClickableText(modifier = Modifier.fillMaxWidth().wrapContentWidth(), text = clickbleText, onClick = {
        clickbleText.getStringAnnotations(it,it).
                firstOrNull()?.also {it->
                     onTextClicked(it.item)

            Log.e("Screen Click","Screen Click ${it.item}")
        }
    })
}
@Composable
fun ClickBleAlreadyHaveAccount(onTextClicked:(String)->Unit) {
    val initlaText="Already have account? "
    val Sigin="Sign In"
    val clickbleText= buildAnnotatedString {
        append(initlaText)
        withStyle(style = SpanStyle(color = Color.DarkGray)){
            pushStringAnnotation(tag = "signin", annotation = "signin")
            append(Sigin)
        }
    }
    ClickableText(modifier = Modifier.fillMaxWidth().wrapContentWidth(), text = clickbleText, onClick = {
        clickbleText.getStringAnnotations(it,it).
                firstOrNull()?.also {it->
                     onTextClicked(it.item)

            Log.e("Screen Click","Screen Click ${it.item}")
        }
    })
}

@Preview
@Composable
private fun TextFieldColors() {
    var text by remember { mutableStateOf("") }


}