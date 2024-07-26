package com.example.composeloginregistration.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user")
data class UserEntity(@PrimaryKey(autoGenerate = true)val id:Int=0,
                      var fname:String="",var lname:String="",var email:String="",var password:String="")
