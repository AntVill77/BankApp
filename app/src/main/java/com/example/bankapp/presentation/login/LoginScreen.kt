package com.example.bankapp.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.bankapp.core.extensions.oauthManager

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginClick: () -> Unit
) {

    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->

            when (event) {
                LoginUiEvent.LaunchOAuth -> {
                    val manager =
                        context.oauthManager()
                    manager.loadConfiguration {
                        if (it) {
                            val intent =
                                manager.getAuthorizationIntent()
                            context.startActivity(intent)
                        }
                    }
                }

                is LoginUiEvent.ShowError -> {
                }
                else -> {}
            }

        }

    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bank App",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "OAuth 2.0 + Keycloak",
            style = MaterialTheme.typography.bodyLarge
        )


        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
             viewModel.login()
            }
        ){
            Text("Iniciar sesión")
        }

        if (state.loading) {

            CircularProgressIndicator()

        }
    }

}
