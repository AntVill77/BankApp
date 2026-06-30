package com.example.bankapp.data.repository

import com.example.bankapp.data.remote.AuthApi
import com.example.bankapp.domain.model.User
import com.example.bankapp.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(

    private val api: AuthApi

): AuthRepository {

    override suspend fun getUser(): User {

        val response = api.getUser()

        return User(

            response.id,

            response.name,

            response.email

        )

    }

}