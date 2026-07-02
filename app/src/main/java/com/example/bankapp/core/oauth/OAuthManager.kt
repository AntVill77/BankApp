package com.example.bankapp.core.oauth

import android.app.Activity
import android.net.Uri
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationService
import net.openid.appauth.AuthorizationServiceConfiguration
import net.openid.appauth.ResponseTypeValues
import javax.inject.Inject

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

    fun login(activity: Activity){
        val intent =

            authService
                .getAuthorizationRequestIntent(

                    getRequest()

                )

        activity.startActivity(intent)
    }
}