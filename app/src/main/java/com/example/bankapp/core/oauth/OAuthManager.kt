package com.example.bankapp.core.oauth

import android.net.Uri
import android.content.Context
import android.content.Intent
import dagger.hilt.android.qualifiers.ApplicationContext
import net.openid.appauth.AuthorizationException
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationResponse
import net.openid.appauth.AuthorizationService
import net.openid.appauth.AuthorizationServiceConfiguration
import net.openid.appauth.ResponseTypeValues
import net.openid.appauth.TokenRequest
import net.openid.appauth.TokenResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OAuthManager @Inject constructor(

    @ApplicationContext
    private val context: Context

) {

    private val authService =
        AuthorizationService(context)

    private var configuration: AuthorizationServiceConfiguration? = null


    fun loadConfiguration(
        callback: (Boolean) -> Unit
    ) {
        AuthorizationServiceConfiguration.fetchFromIssuer(

            Uri.parse(OAuthConfig.ISSUER)

        ) { config, ex ->

            if (config != null) {
                configuration = config
                callback(true)

            } else {
                ex?.printStackTrace()
                callback(false)
            }

        }

    }

    fun getRequest(): AuthorizationRequest {

        val config = requireNotNull(configuration) {
            "OAuth configuration has not been loaded."
        }
        return AuthorizationRequest.Builder(

            config,

            OAuthConfig.CLIENT_ID,

            ResponseTypeValues.CODE,

            Uri.parse(OAuthConfig.REDIRECT_URI)

        )
            .setScopes(
                "openid",
                "profile",
                "email"
            )
            .build()

    }

    fun getAuthorizationIntent(): Intent {

        return authService.getAuthorizationRequestIntent(
            getRequest()
        )
    }

    fun performTokenRequest(
        response: AuthorizationResponse,
        callback: (TokenResponse?, AuthorizationException?) -> Unit
    ) {

        val tokenRequest: TokenRequest =
            response.createTokenExchangeRequest()

        authService.performTokenRequest(
            tokenRequest
        ) { tokenResponse, exception ->

            callback(tokenResponse, exception)

        }

    }
}