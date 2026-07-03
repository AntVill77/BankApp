package com.example.bankapp.di

import com.example.bankapp.core.oauth.AuthCoordinator
import com.example.bankapp.core.oauth.OAuthManager
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface OAuthEntryPoint {

    fun oauthManager(): OAuthManager

    fun authCoordinator(): AuthCoordinator

}