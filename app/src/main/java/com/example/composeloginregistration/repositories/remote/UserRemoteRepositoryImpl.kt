package com.example.composeloginregistration.repositories.remote

import android.content.Context
import android.util.Log
import com.example.composeloginregistration.database.entities.UserEntity
import com.example.composeloginregistration.screens.auth.viewmodel.AuthenticationViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserRemoteRepositoryImpl(val ctx: Context):UserRemoteRepositories {
    override suspend fun insertUser(
        userEntity: UserEntity,
        listener: AuthenticationViewModel.RemoteResponseHandler
    ):Long {
        lateinit var auth: FirebaseAuth
        auth = Firebase.auth

        auth.createUserWithEmailAndPassword(userEntity.email, userEntity.password)
            .addOnCompleteListener {
                    task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "createUserWithEmail:success")
                    val user = auth.currentUser
                    listener.onRemoteResponse(user.toString(),200)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmail:failure", task.exception)
                    listener.onRemoteResponse("User Registration Failed",201)

                }
            }



        return 1;
    }

     suspend fun signinUser(userEntity: UserEntity,
                            listener: AuthenticationViewModel.RemoteResponseHandler
     ):Long {
        lateinit var auth: FirebaseAuth
        auth = Firebase.auth

        auth.signInWithEmailAndPassword(userEntity.email, userEntity.password)
            .addOnCompleteListener {
                    task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "createUserWithEmail:success")
                    val user = auth.currentUser
                    listener.onRemoteResponse(user.toString(),200)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmail:failure", task.exception)

                    listener.onRemoteResponse("User Authentication Failed",201)
                }
            }



        return 1;
    }
}