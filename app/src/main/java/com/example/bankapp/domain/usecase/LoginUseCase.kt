package com.example.bankapp.domain.usecase

import android.app.Activity
import com.example.bankapp.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(

    private val repository: AuthRepository

) {

    operator fun invoke(
        activity: Activity
    ) {

        repository.login(activity)

    }

}