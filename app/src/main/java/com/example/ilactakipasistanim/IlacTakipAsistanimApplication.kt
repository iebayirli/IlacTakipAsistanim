package com.example.ilactakipasistanim

import android.app.Application
import com.example.ilactakipasistanim.di.commonModule
import com.example.ilactakipasistanim.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class IlacTakipAsistanimApplication : Application() {
    val TAG = IlacTakipAsistanimApplication::class.java.simpleName
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@IlacTakipAsistanimApplication)
            modules(listOf(presenterModule, commonModule))
        }

    }
}