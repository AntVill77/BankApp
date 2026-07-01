package com.example.bankapp.di

import android.content.Context
import com.example.bankapp.core.oauth.OAuthManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OAuthModule {

    @Provides
    @Singleton
    fun provideOAuthManager(
        @ApplicationContext context: Context
    ): OAuthManager {
        return OAuthManager(context)
    }
}