package com.example.composeloginregistration.screens.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun NotesScreen(modifier: Modifier = Modifier) {
    val coroutineScope= rememberCoroutineScope()
    val ctxt= LocalContext.current


        Scaffold() {contentPadding->
            Surface(onClick = {  }, modifier = Modifier.padding(contentPadding)) {


            }

        }


}