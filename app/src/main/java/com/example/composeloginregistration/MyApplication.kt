package com.example.composeloginregistration

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.composeloginregistration.containers.AppContainer
import com.example.composeloginregistration.containers.AppContainerImpl


class MyApplication:Application() {
    lateinit var container: AppContainer

    lateinit var sharedPref:SharedPreferences
    fun setUser(user_id:String)
    {
      val editor=  sharedPref.edit()
        editor.putString("user_id",user_id)
        editor.apply()
    }

    fun getUserId(): String?
    {
       return sharedPref.getString("user_id","")
    }
    override fun onCreate() {
        super.onCreate()
         sharedPref = getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        container=AppContainerImpl(this)
    }
}