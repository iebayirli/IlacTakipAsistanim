package com.example.ilactakipasistanim.di.network

import com.example.ilactakipasistanim.common.ApplicationConstant
import com.example.ilactakipasistanim.rest.EnabizLoginService
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit


val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideService<EnabizLoginService>(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(ApplicationConstant.API_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    val cookieManager = CookieManager()
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
    //create a cookieManager so your client can be cookie persistant
//    return OkHttpClient().newBuilder().cookieJar(JavaNetCookieJar(cookieManager))
//        .addInterceptor(authInterceptor).build()
    return OkHttpClient().newBuilder()
        .connectTimeout(40,TimeUnit.SECONDS)
        .readTimeout(40,TimeUnit.SECONDS)
        .addInterceptor(authInterceptor)
        .build()
}

inline fun <reified T> provideService(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}

