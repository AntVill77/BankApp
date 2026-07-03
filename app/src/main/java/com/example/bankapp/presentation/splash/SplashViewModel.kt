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

    private val _state = MutableStateFlow(SplashUiState())
    val state: StateFlow<SplashUiState> = _state


  /*  init {
        checkSession()
    }*/

    fun checkSession() {

        viewModelScope.launch {

            val hasSession = checkSessionUseCase()

            _state.value = _state.value.copy(
                isLoading = false,
                navigateToHome = hasSession,
                navigateToLogin = !hasSession
            )

        }

    }
}