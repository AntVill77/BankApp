package com.example.bankapp.presentation.login

object LoginContract {

    data class State(
        val loading: Boolean = false,
        val error: String? = null
    )

    sealed interface Intent {
        data object LoginClicked : Intent
    }

    sealed interface Effect {

        data object LaunchOAuth : Effect
        data object NavigateHome : Effect
        data class ShowError(
            val message: String
        ) : Effect
    }
}

