package com.example.bankapp.core.oauth

sealed interface OAuthResult {

    data object Success : OAuthResult

    data class Error(
        val message: String
    ) : OAuthResult

}