package com.example.composeloginregistration.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun NormalTextComponent(text:String="") {
    Text(text,
        modifier = Modifier.heightIn().fillMaxWidth(),
        style = TextStyle(
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            lineHeight = TextUnit(30f, TextUnitType.Em)
        )
    )
}

@Preview
@Composable
fun HeaderTextComponent(text:String="") {
    Text(text,
        modifier = Modifier.heightIn().fillMaxWidth(),
        style = TextStyle(
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            lineHeight = TextUnit(30f, TextUnitType.Em)
        )
    )
}