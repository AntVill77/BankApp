package com.example.bankapp.core.oauth.model

import com.example.bankapp.core.oauth.OAuthConfig

data class RefreshTokenRequest(
    val grant_type: String = "refresh_token",
    val refresh_token: String,
    val client_id: String = OAuthConfig.CLIENT_ID
)
