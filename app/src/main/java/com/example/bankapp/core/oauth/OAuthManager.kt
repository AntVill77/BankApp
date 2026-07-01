package com.example.bankapp.core.oauth

import android.app.Activity
import android.net.Uri
import android.content.Context
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationService
import net.openid.appauth.AuthorizationServiceConfiguration
import net.openid.appauth.ResponseTypeValues

class OAuthManager(

    private val context: Context

) {

    private val authService =
        AuthorizationService(context)

    private lateinit var configuration:
            AuthorizationServiceConfiguration


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

                callback(false)

            }

        }

    }

    fun getRequest():
            AuthorizationRequest {
        return AuthorizationRequest.Builder(

            configuration,

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

    fun login(

        activity: Activity

    ){
        val intent =

            authService
                .getAuthorizationRequestIntent(

                    getRequest()

                )

        activity.startActivity(intent)
    }
}