package com.example.bankapp.core.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(
    name = "bank_app_preferences"
)

@Singleton
class TokenStorage @Inject constructor(

    @ApplicationContext
    private val context: Context

) {
    private object PreferencesKeys {

        val ACCESS_TOKEN =
            stringPreferencesKey("access_token")

        val REFRESH_TOKEN =
            stringPreferencesKey("refresh_token")

        val ID_TOKEN =
            stringPreferencesKey("id_token")

        val EXPIRES_AT =
            longPreferencesKey("expires_at")

        val TOKEN_TYPE =
            stringPreferencesKey("token_type")

        val SCOPE =
            stringPreferencesKey("scope")

    }

    suspend fun saveSession(session: TokenEntity) {

        context.dataStore.edit { preferences ->

            preferences[PreferencesKeys.ACCESS_TOKEN] = session.accessToken
            preferences[PreferencesKeys.REFRESH_TOKEN] = session.refreshToken
            preferences[PreferencesKeys.ID_TOKEN] = session.idToken ?: ""
            preferences[PreferencesKeys.EXPIRES_AT] = session.expiresAt
            preferences[PreferencesKeys.TOKEN_TYPE] = session.tokenType
            preferences[PreferencesKeys.SCOPE] = session.scope

        }
    }

    fun getSession(): Flow<TokenEntity?> {

        return context.dataStore.data.map  { preferences ->

            val accessToken =
                preferences[PreferencesKeys.ACCESS_TOKEN]

            val refreshToken =
                preferences[PreferencesKeys.REFRESH_TOKEN]

            if (accessToken.isNullOrBlank() ||
                refreshToken.isNullOrBlank()
            ) {
                return@map null
            }

            TokenEntity(
                accessToken = accessToken,
                refreshToken = refreshToken,
                idToken = preferences[PreferencesKeys.ID_TOKEN]
                        ?.takeIf { it.isNotBlank() },
                expiresAt = preferences[PreferencesKeys.EXPIRES_AT] ?: 0L,
                tokenType = preferences[PreferencesKeys.TOKEN_TYPE] ?: "Bearer",
                scope = preferences[PreferencesKeys.SCOPE] ?: ""
            )
        }
    }

    suspend fun hasSession(): Boolean {

        return getSession().firstOrNull() != null

    }

    suspend fun clear() {

        context.dataStore.edit {

            it.clear()

        }

    }

}



