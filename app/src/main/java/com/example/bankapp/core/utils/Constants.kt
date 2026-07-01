package com.example.bankapp.core.utils

object Constants {

    const val BASE_URL =
        "https://jsonplaceholder.typicode.com/"

}


object OAuthConfig {

    const val CLIENT_ID = "bank-mobile"

    const val REDIRECT_URI =
        "com.ant.bankapp:/oauth2redirect"

    const val AUTH_URI =
        "http://10.0.2.2:8080/realms/bank/protocol/openid-connect/auth"

    const val TOKEN_URI =
        "http://10.0.2.2:8080/realms/bank/protocol/openid-connect/token"

}