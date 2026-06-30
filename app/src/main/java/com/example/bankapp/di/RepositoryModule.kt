package com.example.bankapp.di

import com.example.bankapp.data.repository.AuthRepositoryImpl
import com.example.bankapp.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(
        repository: AuthRepositoryImpl
    ): AuthRepository

}