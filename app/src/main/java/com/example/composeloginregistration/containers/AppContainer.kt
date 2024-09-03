package com.example.composeloginregistration.containers

import com.example.composeloginregistration.repositories.UserRepositories
import com.example.composeloginregistration.repositories.UserRepositoryImpl
import com.example.composeloginregistration.repositories.remote.UserRemoteRepositoryImpl

interface AppContainer {
    val userRepositories:UserRepositoryImpl
    val userRemoteRepositories: UserRemoteRepositoryImpl
}