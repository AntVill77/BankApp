package com.example.bankapp.data.repository

import android.app.Activity
import com.example.bankapp.core.oauth.OAuthManager
import com.example.bankapp.data.remote.AuthApi
import com.example.bankapp.domain.model.User
import com.example.bankapp.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(

    private val oauthManager: OAuthManager

) : AuthRepository {

    override fun login(activity: Activity) {

        oauthManager.login(activity)

    }

}