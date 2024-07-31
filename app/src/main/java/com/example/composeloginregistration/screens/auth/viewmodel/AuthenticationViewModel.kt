package com.example.composeloginregistration.screens.auth.viewmodel

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeloginregistration.MyApplication
import com.example.composeloginregistration.database.entities.UserEntity
import com.example.composeloginregistration.repositories.UserRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class AuthenticationViewModel(
    val userRepositoryImpl: UserRepositoryImpl,
    val application: MyApplication
):ViewModel() {

   var userInputState by  mutableStateOf(UserInputState())
    val responseHandler: MutableSharedFlow<ResponseHandler> = MutableSharedFlow()

    fun updateUserInput(userEntity: UserEntity){
        userInputState= UserInputState(userEntity/*,validateUserInput(userEntity)*/)
    }

     fun validateUserInput(userEntitys: UserEntity=userInputState.userEntity): Boolean {
         var msg=""
         var validate=with(userEntitys){
             fname.isNotEmpty()&&lname.isNotEmpty()&&email.isNotEmpty()&&password.isNotEmpty()
         }
         if(validate){
             if(!Patterns.EMAIL_ADDRESS.matcher(userEntitys.email).matches())
             {
                 validate=false;
                 msg="Please enter valid email id"
             }
             if(validate)
             {
                 if(userEntitys.password.length<6)
                 {
                     validate=false;
                     msg="Password should minimum 6 characters"
                 }
             }
         }else
         {
             msg="Please fill all details"
         }

         if(!validate) {
             viewModelScope.launch {
                 responseHandler.emit(ResponseHandler(msg, 201))
             }
             return false
         }
         return true
    }
    suspend fun insertUser(userEntity: UserEntity)
    {
        if(validateUserInput(userEntity)) {
            var insert = userRepositoryImpl.insertUser(userEntity) as Long
            Log.e("insert","insert $insert")
            if(insert>0)
            {
                responseHandler.emit(ResponseHandler("User registered successfully",200))
            }
        }


    }
    suspend fun getAllUsers(userEntity: UserEntity)
    {
        userRepositoryImpl.getchAll().flowOn(Dispatchers.IO).collect{
            Log.e("Database Size","Database Size ${it.size}}" )

        }

    }

    suspend fun checkUser(email:String,password:String)
    {
         if(email.isEmpty()||password.isEmpty())
         {
             responseHandler.emit(ResponseHandler("Enter valid credentials",201))
             return
         }
    userRepositoryImpl.checkUser(email,password).collect{
        Log.e("listData","listData users list ${it?.size}}")
        if(it==null||it?.isEmpty()==true)
        {
            responseHandler.emit(ResponseHandler("User Doesn't exist, Please check your credentials",201))

        }else {
            application.setUser(it.get(0).id.toString())
            responseHandler.emit(ResponseHandler("Login Successfully", 200))

        }
    }


    }
    suspend fun checkUser(id:String)
    {

    userRepositoryImpl.checkUser(id).collect{
        Log.e("listData","listData users list ${it?.size}}")
        if(it==null||it?.isEmpty()==true)
        {
            responseHandler.emit(ResponseHandler("User Doesn't exist, Please check your credentials",201))

        }else {
            application.setUser(it.get(0).id.toString())
            responseHandler.emit(ResponseHandler("Login Successfully", 202))

        }
    }


    }

    data class UserInputState(
        val userEntity: UserEntity= UserEntity(),
        val isValida:Boolean=false

        )

    data class ResponseHandler(val msg:String="",val resCode:Int=0)
}