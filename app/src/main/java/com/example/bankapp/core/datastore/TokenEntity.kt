package com.example.bankapp.core.datastore

data class TokenEntity(
    val accessToken: String,
    val refreshToken: String,
    val idToken: String?,
    val expiresAt: Long,
    val tokenType: String,
    val scope: String
)