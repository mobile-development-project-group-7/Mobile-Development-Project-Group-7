package com.example.mdp7

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserViewModel: ViewModel() {
    var username = mutableStateOf("")

    fun loginUser(email: String, password:String){
        Firebase.auth
            .signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                username.value = email
            }
    }


    fun logoutUser(){
        Firebase.auth.signOut()
        username.value = ""
    }
}