package com.example.composeloginregistration.navigation

import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.view.KeyEventDispatcher.Component

val LocalOnBackPressedDispatcher=staticCompositionLocalOf<OnBackPressedDispatcherOwner?> {null

}

class ComposableBackNavigationHandler(enabled: Boolean): OnBackPressedCallback(enabled) {
    lateinit var onbackPressed:()->Unit
    override fun handleOnBackPressed() {
        onbackPressed()
    }
}

@Composable
fun SystemBackButtonHandler(enabled:Boolean=true,onBackPressed:()->Unit) {
    CompositionLocalProvider(LocalOnBackPressedDispatcher provides LocalLifecycleOwner.current as ComponentActivity){
        val dispatcher= (LocalOnBackPressedDispatcher.current ?: return@CompositionLocalProvider).onBackPressedDispatcher
        val handler= remember { ComposableBackNavigationHandler(enabled) }
        DisposableEffect(dispatcher) {
            dispatcher.addCallback(handler)

            onDispose { handler.remove() }
        }
        LaunchedEffect(enabled) {
            handler.isEnabled=enabled
            handler.onbackPressed=onBackPressed
        }

    }
}