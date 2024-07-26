package com.example.composeloginregistration.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.composeloginregistration.database.entities.UserEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(userEntity: UserEntity):Long

    @Query("select * from user")
    fun getchAll():Flow<List<UserEntity>>

    @Query("select * from user where email=:email and password=:password")
    fun checkUser(email:String,password:String):Flow<List<UserEntity>>
}