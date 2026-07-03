package com.example.bankapp.domain.model

data class AuthSession(

    val accessToken: String,

    val refreshToken: String,

    val idToken: String? = null,

    val tokenType: String = "Bearer",

    val expiresAt: Long,

    val scope: String = ""

)