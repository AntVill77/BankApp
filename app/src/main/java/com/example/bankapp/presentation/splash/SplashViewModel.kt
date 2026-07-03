package com.example.bankapp.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankapp.domain.usecase.CheckSessionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(

    private val checkSessionUseCase: CheckSessionUseCase

) : ViewModel() {

    private val _state = MutableStateFlow<SplashState>(
        SplashState.Loading
    )

    val state: StateFlow<SplashState> = _state

    init {

        checkSession()

    }

    private fun checkSession() {

        viewModelScope.launch {

            val session = checkSessionUseCase()

            _state.value =

                if (session == null)

                    SplashState.NavigateToLogin

                else

                    SplashState.NavigateToHome

        }

    }
}