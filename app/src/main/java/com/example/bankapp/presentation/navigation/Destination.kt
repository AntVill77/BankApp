package com.example.bankapp.presentation.navigation

sealed class Destination(
    val route: String
) {

    data object Splash : Destination("splash")

    data object Login : Destination("login")

    data object Home : Destination("home")

}

