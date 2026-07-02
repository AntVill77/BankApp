package com.example.bankapp.core.session

sealed interface AuthState{

    data object Authenticated:AuthState

    data object NotAuthenticated:AuthState

}