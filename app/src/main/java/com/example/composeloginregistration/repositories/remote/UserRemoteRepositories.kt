package com.example.composeloginregistration.repositories.remote

import com.example.composeloginregistration.database.entities.UserEntity
import com.example.composeloginregistration.screens.auth.viewmodel.AuthenticationViewModel

interface UserRemoteRepositories {
    suspend fun insertUser(
        userEntity: UserEntity,
        param: AuthenticationViewModel.RemoteResponseHandler
    ):Long

}