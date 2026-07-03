package com.example.bankapp.presentation.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppNavigator @Inject constructor() {

    private val _navigationEvent = MutableSharedFlow<Destination>()
    val navigationEvent: SharedFlow<Destination> = _navigationEvent

    suspend fun navigate(destination: Destination) {
        _navigationEvent.emit(destination)
    }
}

