package com.example.composeloginregistration.screens.auth

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.composeloginregistration.MyApplication
import com.example.composeloginregistration.screens.auth.viewmodel.AuthenticationViewModel


import androidx.lifecycle.viewmodel.initializer

object AppViewModelProvider {
    val factory= viewModelFactory{
        initializer {
            val myRepository = (this[APPLICATION_KEY] as MyApplication).container.userRepositories
            val myRemoteRepository = (this[APPLICATION_KEY] as MyApplication).container.userRemoteRepositories
           val application= (this[APPLICATION_KEY] as MyApplication)
            AuthenticationViewModel(myRepository,myRemoteRepository,application)
        }

    }
}

private fun InitializerViewModelFactoryBuilder.myApplication(): MyApplication {
    return  (AndroidViewModelFactory.APPLICATION_KEY as MyApplication)
}
