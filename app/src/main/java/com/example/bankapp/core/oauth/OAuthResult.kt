package com.example.bankapp.core.oauth

sealed interface OAuthResult {

    sealed interface OAuthResult {

        data class Success(
            val authorizationCode: String
        ) : OAuthResult

        data class Error(
            val message: String
        ) : OAuthResult

        data object Cancelled : OAuthResult
    }

}