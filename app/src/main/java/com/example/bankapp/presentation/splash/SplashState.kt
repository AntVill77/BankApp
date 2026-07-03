package com.example.bankapp.presentation.splash

sealed interface SplashState {

    data object Loading : SplashState

    data object NavigateToLogin : SplashState

    data object NavigateToHome : SplashState

}