package com.example.bankapp.presentation.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

/*
@Composable
fun LoginRoute(
    viewModel: LoginViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()

    LoginScreen(
        state = state,
        onLogin = {
            viewModel.onIntent(
                LoginContract.Intent.LoginClicked
            )
        }

    )
}*/

@Composable
fun LoginRoute(
    viewModel: LoginViewModel = hiltViewModel()
) {

    LoginScreen(
        state = viewModel.state.value,
        onLogin = {
            viewModel.onIntent(
                LoginContract.Intent.LoginClicked
            )
        }
    )
}
