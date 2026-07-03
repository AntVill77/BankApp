package com.example.bankapp.core.extensions

import android.content.Context
import com.example.bankapp.di.OAuthEntryPoint
import dagger.hilt.android.EntryPointAccessors

fun Context.oauthManager() =
    EntryPointAccessors
        .fromApplication(
            this,
            OAuthEntryPoint::class.java
        )
        .oauthManager()