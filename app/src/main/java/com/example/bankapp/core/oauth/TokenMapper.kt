package com.example.bankapp.core.oauth

import com.example.bankapp.domain.model.AuthSession
import net.openid.appauth.TokenResponse

object TokenMapper {

    fun map(response: TokenResponse): AuthSession {

        return AuthSession(

            accessToken = response.accessToken.orEmpty(),

            refreshToken = response.refreshToken.orEmpty(),

            idToken = response.idToken,

            tokenType = response.tokenType ?: "Bearer",

            expiresAt = response.accessTokenExpirationTime ?: 0L,

            scope = response.scope ?: ""

        )

    }

}