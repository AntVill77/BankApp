package com.example.bankapp.data.remote.dto

data class OAuthTokenDto(

    val accessToken: String,

    val refreshToken: String,

    val idToken: String?,

    val tokenType: String,

    val expiresAt: Long,

    val scope: String

)