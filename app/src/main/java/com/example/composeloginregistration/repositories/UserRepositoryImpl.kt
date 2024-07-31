package com.example.composeloginregistration.repositories

import androidx.lifecycle.LiveData
import com.example.composeloginregistration.database.dao.UserDao
import com.example.composeloginregistration.database.entities.UserEntity
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(var userDao: UserDao):UserRepositories {
    override suspend fun insertUser(userEntity: UserEntity):Long {
       return userDao.insertUser(userEntity)
    }

    override fun getchAll(): Flow<List<UserEntity>> {
      return  userDao.getchAll()
    }

    override fun checkUser(email: String, password: String): Flow<List<UserEntity>> {
      return  userDao.checkUser(email,password)
    }
    override fun checkUser(id: String): Flow<List<UserEntity>> {
      return  userDao.checkUser(id)
    }
}