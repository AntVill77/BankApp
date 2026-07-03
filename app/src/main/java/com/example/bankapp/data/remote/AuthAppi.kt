package com.example.bankapp.data.remote

import com.example.bankapp.data.remote.dto.UserResponse
import retrofit2.http.GET

interface AuthApi {

    @GET("users/1")
    suspend fun getUser(): UserResponse

}