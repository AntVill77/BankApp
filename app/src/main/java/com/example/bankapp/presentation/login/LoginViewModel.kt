package com.example.bankapp.presentation.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(


): ViewModel(){

    private val _events = MutableSharedFlow<LoginEvent>()

    val events = _events.asSharedFlow()

    fun login() {
    }
}