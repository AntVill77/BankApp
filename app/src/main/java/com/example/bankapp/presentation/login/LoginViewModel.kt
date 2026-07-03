package com.example.bankapp.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(LoginContract.State())
    val state: StateFlow<LoginContract.State> = _state.asStateFlow()
    private val _effect = MutableSharedFlow<LoginContract.Effect>()
    val effect = _effect.asSharedFlow()

    private val _events = MutableSharedFlow<LoginUiEvent>()

    val events: SharedFlow<LoginUiEvent> = _events.asSharedFlow()

    fun onIntent(intent: LoginContract.Intent){
        when(intent){
            LoginContract.Intent.LoginClicked->{
                login()
            }
        }
    }

    fun login(){
        viewModelScope.launch {

            _state.value = _state.value.copy(loading = true)

            _events.emit(LoginUiEvent.LaunchOAuth)

        }
    }
}