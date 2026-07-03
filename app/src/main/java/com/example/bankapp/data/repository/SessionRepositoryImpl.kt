package com.example.bankapp.data.repository

import com.example.bankapp.core.datastore.TokenEntity
import com.example.bankapp.core.datastore.TokenStorage
import com.example.bankapp.domain.model.AuthSession
import com.example.bankapp.domain.repository.SessionRepository
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionRepositoryImpl @Inject constructor(
    private val tokenStorage: TokenStorage
) : SessionRepository {

    override suspend fun getSession(): AuthSession? {
        val token = tokenStorage.getSession().firstOrNull()

        return token?.let {

            AuthSession(
                accessToken = it.accessToken,
                refreshToken = it.refreshToken,
                idToken = it.idToken,
                expiresAt = it.expiresAt,
                tokenType = it.tokenType,
                scope = it.scope
            )

        }
    }

    override suspend fun saveSession(
        session: AuthSession
    ) {

        tokenStorage.saveSession(

            TokenEntity(
                accessToken = session.accessToken,
                refreshToken = session.refreshToken,
                idToken = session.idToken,
                expiresAt = session.expiresAt,
                tokenType = session.tokenType,
                scope = session.scope
            )

        )

    }

    override suspend fun clearSession() {
        tokenStorage.clear()

    }
}
