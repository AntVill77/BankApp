package com.example.bankapp.core.network

import com.example.bankapp.domain.repository.SessionRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val sessionRepository: SessionRepository
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val session = runBlocking {
            sessionRepository.getSession()
        }

        val request = chain.request().newBuilder()

        session?.accessToken?.let { token ->
            request.addHeader(
                "Authorization",
                "Bearer $token"
            )
        }

        return chain.proceed(request.build())
    }
}