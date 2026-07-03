package com.example.bankapp.domain.repository

import com.example.bankapp.domain.model.AuthSession

interface SessionRepository {

    suspend fun getSession(): AuthSession?

    suspend fun saveSession(
        session: AuthSession
    )

    suspend fun clearSession()

}