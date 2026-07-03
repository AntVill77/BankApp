package com.example.bankapp.presentation.login

/*sealed interface LoginEvent {

    data object StartLogin : LoginEvent

    data class Error(
        val message: String
    ) : LoginEvent

}*/

sealed interface LoginUiEvent {

    data object LaunchOAuth : LoginUiEvent

    data object NavigateHome : LoginUiEvent

    data class ShowError(
        val message:String
    ):LoginUiEvent

}
