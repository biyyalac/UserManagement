package com.example.composeloginregistration.containers

import com.example.composeloginregistration.repositories.UserRepositories
import com.example.composeloginregistration.repositories.UserRepositoryImpl

interface AppContainer {
    val userRepositories:UserRepositoryImpl
}