package com.example.composeloginregistration.repositories

import androidx.lifecycle.LiveData
import com.example.composeloginregistration.database.entities.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepositories {
    suspend fun insertUser(userEntity: UserEntity):Long
     fun getchAll(): Flow<List<UserEntity>>
     fun checkUser(email:String,password:String): Flow<List<UserEntity>>
     fun checkUser(id:String): Flow<List<UserEntity>>
}