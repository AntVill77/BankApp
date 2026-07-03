package com.example.bankapp.core.network

import com.example.bankapp.core.oauth.OAuthManager
import com.example.bankapp.core.oauth.TokenMapper
import com.example.bankapp.domain.repository.SessionRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val oauthManager: OAuthManager,
    private val sessionRepository: SessionRepository
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {

        if (responseCount(response) >= 2) return null

        val session = runBlocking {
            sessionRepository.getSession()
        } ?: return null

        val refreshToken = session.refreshToken ?: return null

        val tokenResponse = runBlocking {
            oauthManager.refreshTokenSync(refreshToken)
        } ?: return null

        val newSession = TokenMapper.map(tokenResponse)

        runBlocking {
            sessionRepository.saveSession(newSession)
        }

        return response.request.newBuilder()
            .header(
                "Authorization",
                "Bearer ${newSession.accessToken}"
            )
            .build()
    }

    private fun responseCount(response: Response): Int {
        var count = 1
        var r = response.priorResponse
        while (r != null) {
            count++
            r = r.priorResponse
        }
        return count
    }
}

