package com.example.composeloginregistration.containers

import android.content.Context
import com.example.composeloginregistration.database.UserDatabase
import com.example.composeloginregistration.repositories.UserRepositories
import com.example.composeloginregistration.repositories.UserRepositoryImpl

class AppContainerImpl(context:Context) :AppContainer {
    override val userRepositories: UserRepositoryImpl by lazy {
        UserRepositoryImpl(UserDatabase.getDatabase(context).userDao())
    }

}