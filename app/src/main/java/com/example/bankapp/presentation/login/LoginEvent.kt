package com.example.bankapp.presentation.login

/*sealed interface LoginEvent {

    data object StartLogin : LoginEvent

    data class Error(
        val message: String
    ) : LoginEvent

}*/

sealed interface LoginEvent {

    data object LaunchOAuth : LoginEvent

    data object NavigateHome : LoginEvent

    data class ShowError(
        val message:String
    ):LoginEvent

}
