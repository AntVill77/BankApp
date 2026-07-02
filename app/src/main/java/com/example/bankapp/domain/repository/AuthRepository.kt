package com.example.bankapp.domain.repository

import android.app.Activity
import com.example.bankapp.domain.model.User

interface AuthRepository {

   // suspend fun getUser(): User

    fun login(activity: Activity)

}