package com.example.bankapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bankapp.presentation.home.HomeScreen
import com.example.bankapp.presentation.login.LoginScreen
import com.example.bankapp.presentation.splash.SplashScreen

@Composable
fun BankNavGraph(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destinations.Splash.route
    ){
        composable(Destinations.Splash.route) {

            SplashScreen(
                navController = navController
            )

        }

        composable(Destinations.Login.route) {

            LoginScreen(onLoginClick = {})

        }

        composable(Destinations.Home.route) {

            HomeScreen()

        }

    }
}