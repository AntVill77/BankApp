package com.example.bankapp.presentation.login

import android.app.Activity
import com.example.bankapp.core.oauth.OAuthManager
import javax.inject.Inject

class LoginCoordinator @Inject constructor(

    private val oauthManager: OAuthManager

) {

    fun startLogin(
        activity: Activity
    ) {

        oauthManager.login(activity)

    }

}



