package com.example.composeloginregistration.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.composeloginregistration.database.dao.UserDao
import com.example.composeloginregistration.database.entities.UserEntity

@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class UserDatabase:RoomDatabase() {
   abstract fun userDao():UserDao
   companion object{
      @Volatile
      private var instance:UserDatabase?=null
      fun getDatabase(ctx:Context):UserDatabase{
         return instance?: synchronized(this){
            Room.databaseBuilder(ctx,UserDatabase::class.java,"userdb")
               .build()
               .also { instance=it }
         }
      }
   }
}