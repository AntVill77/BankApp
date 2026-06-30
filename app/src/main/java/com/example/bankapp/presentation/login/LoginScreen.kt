package com.example.bankapp.presentation.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
){

    Column(

        modifier = Modifier.fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center

    ){

        Button(

            onClick = {
                viewModel.test()
            }

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