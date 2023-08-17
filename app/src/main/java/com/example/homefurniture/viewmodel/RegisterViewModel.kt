package com.example.homefurniture.viewmodel

import androidx.lifecycle.ViewModel
import com.example.homefurniture.data.User
import com.example.homefurniture.utils.Resources
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel  //with the help of HiltViewModel hame viewModel ke liye viewModelfactory banani ni pdti
class RegisterViewModel @Inject constructor(
    private val auth:FirebaseAuth
):ViewModel() {

    private val _register=MutableStateFlow<Resources<FirebaseUser>>(Resources.Loading())

    val register:Flow<Resources<FirebaseUser>> =_register
    fun createdAccountwithEmailAndPass(user: User, password:String){
        auth.createUserWithEmailAndPassword(user.email,password)
            .addOnSuccessListener {

                it.user?.let {

                    _register.value=Resources.Success(it)
                }
            }.addOnFailureListener{

                _register.value=Resources.Error(it.message.toString())
            }
    }
}