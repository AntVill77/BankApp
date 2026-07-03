package com.example.bankapp.presentation.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppNavigator @Inject constructor() {

    private val _navigationEvent = MutableSharedFlow<Destinations>()
    val navigationEvent: SharedFlow<Destinations> = _navigationEvent

    suspend fun navigate(destination: Destinations) {
        _navigationEvent.emit(destination)
    }
}

