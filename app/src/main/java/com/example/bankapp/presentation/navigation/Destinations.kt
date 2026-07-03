package com.example.bankapp.presentation.navigation

sealed class Destinations(
    val route: String
) {

    data object Splash : Destinations("splash")

    data object Login : Destinations("login")

    data object Home : Destinations("home")

}

