package com.example.composeloginregistration

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppViewModel:ViewModel() {
    private val _isReady= MutableStateFlow(false)
    val isReady=_isReady.asStateFlow()
    var user_id= mutableStateOf("")
    init {
        viewModelScope.launch {
            delay(2000)
            _isReady.value=true
        }
    }
}