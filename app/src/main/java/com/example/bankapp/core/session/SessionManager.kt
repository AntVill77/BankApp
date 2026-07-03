package com.example.bankapp.core.session

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private val _authState =
        MutableStateFlow<AuthState>(AuthState.Loading)

    val authState: StateFlow<AuthState> =
        _authState.asStateFlow()

    fun authenticate() {

        _authState.value =
            AuthState.Authenticated

    }

    fun logout() {

        _authState.value =
            AuthState.Unauthenticated

    }

}