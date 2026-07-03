package com.example.bankapp.di

import com.example.bankapp.data.repository.AuthRepositoryImpl
import com.example.bankapp.data.repository.SessionRepositoryImpl
import com.example.bankapp.domain.repository.SessionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /*@Binds
    @Singleton
    abstract fun bindAuthRepository(
        repository: AuthRepositoryImpl
    ): AuthRepository*/

    @Binds
    @Singleton
    abstract fun bindSessionRepository(
        repository: SessionRepositoryImpl
    ): SessionRepository
}