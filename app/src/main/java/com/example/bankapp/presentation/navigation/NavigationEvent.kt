package com.example.bankapp.presentation.navigation

sealed interface NavigationEvent {

    data object NavigateHome : NavigationEvent

    data object NavigateLogin : NavigationEvent

    data object NavigateSplash : NavigationEvent

}

