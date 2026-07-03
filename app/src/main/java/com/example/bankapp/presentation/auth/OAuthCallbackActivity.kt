package com.example.bankapp.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.bankapp.MainActivity
import com.example.bankapp.core.oauth.OAuthManager
import com.example.bankapp.core.oauth.TokenMapper
import com.example.bankapp.domain.model.AuthSession
import com.example.bankapp.domain.repository.SessionRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import net.openid.appauth.AuthorizationException
import net.openid.appauth.AuthorizationResponse
import timber.log.Timber
import javax.inject.Inject


@AndroidEntryPoint
class OAuthCallbackActivity : ComponentActivity() {

    @Inject
    lateinit var oauthManager: OAuthManager

    @Inject
    lateinit var sessionRepository: SessionRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handleAuthorizationResponse()
    }

    private fun handleAuthorizationResponse() {
        val response = AuthorizationResponse.fromIntent(intent)

        val exception = AuthorizationException.fromIntent(intent)

        if (exception != null) {
            //exception.printStackTrace()
            Timber.tag("OAuth")
                .e(exception, "OAuth authorization failed")
            finish()
            return
        }

        if (response == null) {

            Timber.tag("OAuth").e("AuthorizationResponse is null")
            finish()
            return
        }

        oauthManager.performTokenRequest(response) { tokenResponse, tokenException ->

            if (tokenException != null) {

                tokenException.printStackTrace()

                finish()

                return@performTokenRequest

            }

            val token = tokenResponse ?: run {
                finish()
                return@performTokenRequest
            }

            val session = TokenMapper.map(token)
            lifecycleScope.launch {
                sessionRepository.saveSession(session)

                val mainIntent = Intent(
                    this@OAuthCallbackActivity,
                    MainActivity::class.java
                ).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
                }

                startActivity(mainIntent)

                finish()
            }
        }
    }

}
/*@AndroidEntryPoint
class OAuthCallbackActivity : ComponentActivity() {

    @Inject
    lateinit var oauthManager: OAuthManager

    @Inject
    lateinit var sessionRepository: SessionRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val response = AuthorizationResponse.fromIntent(intent)

        if (response != null) {
            oauthManager.performTokenRequest(response) { tokenResponse, _ ->
                if (tokenResponse != null) {
                    lifecycleScope.launch {
                        sessionRepository.saveSession(
                            AuthSession(
                                accessToken = tokenResponse.accessToken ?: "",
                                refreshToken = tokenResponse.refreshToken ?: "",
                                idToken = tokenResponse.idToken,
                                tokenType = tokenResponse.tokenType ?: "Bearer",
                                expiresAt = tokenResponse.accessTokenExpirationTime ?: 0L,
                                scope = tokenResponse.scope ?: ""
                            )
                        )
                        startActivity(Intent(this@OAuthCallbackActivity, MainActivity::class.java))
                        finish()
                    }
                } else {
                    finish()
                }
            }
        } else {
            finish()
        }
    }
}*/
