package com.example.bankapp.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.bankapp.presentation.navigation.Destinations

@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(state) {

        when (state) {
            SplashState.Loading -> Unit
            SplashState.NavigateToLogin -> {
                navController.navigate(
                    Destinations.Login.route
                ) {
                    popUpTo(Destinations.Splash.route) {
                        inclusive = true
                    }
                }
            }

            SplashState.NavigateToHome -> {

                navController.navigate(
                    Destinations.Home.route
                ) {

                    popUpTo(Destinations.Splash.route) {

                        inclusive = true

                    }

                }

            }

        }

    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        CircularProgressIndicator()

    }

}