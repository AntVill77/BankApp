package com.example.bankapp.presentation.login

sealed interface LoginIntent {

    data object LoginClicked : LoginIntent

}

