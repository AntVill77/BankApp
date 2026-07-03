package com.example.bankapp.core.oauth

import android.app.Activity
import android.content.Intent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthCoordinator @Inject constructor(
    private val oauthManager: OAuthManager
) {

    fun startLogin(
        activity: Activity
    ) {

        oauthManager.loadConfiguration { success ->

            if (!success) return@loadConfiguration

            val intent: Intent =
                oauthManager.getAuthorizationIntent()

            activity.startActivity(intent)

        }

    }

}