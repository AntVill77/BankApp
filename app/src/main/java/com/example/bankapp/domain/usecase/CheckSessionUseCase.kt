package com.example.bankapp.domain.usecase

import com.example.bankapp.domain.repository.SessionRepository
import javax.inject.Inject

class CheckSessionUseCase @Inject constructor(

    private val repository: SessionRepository

) {

    suspend operator fun invoke() = repository.getSession()

}