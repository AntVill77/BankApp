package com.example.bankapp.domain.repository

import com.example.bankapp.domain.model.User

interface AuthRepository {

    suspend fun getUser(): User

}