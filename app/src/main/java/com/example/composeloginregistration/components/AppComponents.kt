package com.example.composeloginregistration.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun LoginButtonComponent(value:String="Login") {
    Button(onClick = {}, modifier = Modifier
        .fillMaxWidth()
        .heightIn(48.dp)
        .background(Color.Transparent)
        .padding(0.dp),
        contentPadding = PaddingValues()
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                Brush.linearGradient(listOf(Color.Blue, Color.Red)),
                shape = RoundedCornerShape(30.dp),

                ),
            contentAlignment = Alignment.Center
        ){
            Text(value,
                style = TextStyle(fontSize = 21.sp),
                fontWeight = FontWeight.Bold)
        }
    }
}
@Preview
@Composable
fun NormalTextComponent(text:String="") {
    Text(text,
        modifier = Modifier
            .heightIn()
            .fillMaxWidth(),
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
        modifier = Modifier
            .heightIn()
            .fillMaxWidth(),
        style = TextStyle(
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            lineHeight = TextUnit(30f, TextUnitType.Em)
        )
    )
}


@Preview(showBackground = true)
@Composable
fun DividerComponent() {
    Row(modifier = Modifier
        .fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {

        HorizontalDivider(modifier = Modifier.fillMaxWidth().weight(1f), thickness = DividerDefaults.Thickness, color = Color.Gray)
        Text("OR", style = TextStyle(color = Color.Black, fontSize = 14.sp), modifier = Modifier.padding(5.dp))
        HorizontalDivider(modifier = Modifier.fillMaxWidth().weight(1f), thickness = DividerDefaults.Thickness, color = Color.Gray)

    }
}