package com.example.bankapp.presentation.navigation

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bankapp.core.oauth.AuthCoordinator
import com.example.bankapp.di.OAuthEntryPoint
import com.example.bankapp.presentation.home.HomeScreen
import com.example.bankapp.presentation.login.LoginScreen
import com.example.bankapp.presentation.splash.SplashScreen
import dagger.hilt.android.EntryPointAccessors

@SuppressLint("ContextCastToActivity")
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

            val activity = LocalContext.current as Activity

            val coordinator: AuthCoordinator =
                EntryPointAccessors
                    .fromApplication(
                        activity.applicationContext,
                        OAuthEntryPoint::class.java
                    )
                    .authCoordinator()

            LoginScreen(
                onLoginClick = {
                    coordinator.startLogin(activity)
                }
            )
        }

        composable(Destinations.Home.route) {

            HomeScreen()

        }

    }
}