package com.example.composeloginregistration.containers

import android.content.Context
import com.example.composeloginregistration.database.UserDatabase
import com.example.composeloginregistration.repositories.UserRepositories
import com.example.composeloginregistration.repositories.UserRepositoryImpl
import com.example.composeloginregistration.repositories.remote.UserRemoteRepositoryImpl

class AppContainerImpl(context:Context,
) :AppContainer {
    override val userRepositories: UserRepositoryImpl by lazy {
        UserRepositoryImpl(UserDatabase.getDatabase(context).userDao())
    }
    override val userRemoteRepositories: UserRemoteRepositoryImpl by lazy {
        UserRemoteRepositoryImpl(context)
    }

}