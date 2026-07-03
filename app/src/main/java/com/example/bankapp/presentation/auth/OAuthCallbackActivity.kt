package com.example.bankapp.presentation.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.bankapp.MainActivity
import com.example.bankapp.core.oauth.OAuthManager
import com.example.bankapp.domain.model.AuthSession
import com.example.bankapp.domain.repository.SessionRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import net.openid.appauth.AuthorizationResponse
import javax.inject.Inject

@AndroidEntryPoint
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
}
