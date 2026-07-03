package com.example.bankapp.presentation.splash

data class SplashUiState(
    val isLoading: Boolean = true,
    val navigateToLogin: Boolean = false,
    val navigateToHome: Boolean = false
)

/*
sealed interface SplashState {

    data object Loading : SplashState

    data object NavigateToLogin : SplashState

    data object NavigateToHome : SplashState

}*/
