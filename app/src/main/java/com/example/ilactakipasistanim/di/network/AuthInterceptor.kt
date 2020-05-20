package com.example.ilactakipasistanim.di.network

import okhttp3.*
import java.lang.Exception

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Content-Type", "application/json").build()
        val response = chain.proceed(request)
        return response
    }
}