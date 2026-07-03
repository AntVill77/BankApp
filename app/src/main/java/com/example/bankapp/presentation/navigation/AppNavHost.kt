package com.example.bankapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bankapp.presentation.home.HomeScreen
import com.example.bankapp.presentation.login.LoginRoute
import com.example.bankapp.presentation.splash.SplashScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.Splash.route
    ) {

        composable(Destination.Splash.route) {
            SplashScreen()
        }

        composable(Destination.Login.route) {
            LoginRoute()
        }

        composable(Destination.Home.route) {
            HomeScreen()
        }
    }
}

