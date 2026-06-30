package com.example.bankapp.domain.usecase

import com.example.bankapp.domain.repository.AuthRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(

    private val repository: AuthRepository

) {

    suspend operator fun invoke() = repository.getUser()

}