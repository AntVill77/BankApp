package com.example.bankapp.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankapp.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

    private val getUserUseCase: GetUserUseCase

): ViewModel(){

    fun test(){

        viewModelScope.launch {

            val user = getUserUseCase()

            Log.d("USER",user.toString())

        }

    }

}