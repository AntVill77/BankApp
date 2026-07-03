package com.example.bankapp.core.session

sealed interface AuthState {

    data object Loading : AuthState

    data object Authenticated : AuthState

    data object Unauthenticated : AuthState

}