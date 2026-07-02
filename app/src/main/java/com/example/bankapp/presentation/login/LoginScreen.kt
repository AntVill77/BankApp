package com.example.bankapp.presentation.login

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("ViewModelConstructorInComposable", "ContextCastToActivity")
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
){
    val activity = LocalContext.current as Activity

    Column(

        modifier = Modifier.fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center

    ){

        Button(

            onClick = { }

        ){

            Text("Iniciar sesión")

        }

    }

}


@Composable
@Preview
fun PreviewLogin(){
    LoginScreen()
}