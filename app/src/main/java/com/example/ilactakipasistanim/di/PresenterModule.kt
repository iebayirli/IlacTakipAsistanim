package com.example.ilactakipasistanim.di


import com.example.ilactakipasistanim.ui.main.MainContract
import com.example.ilactakipasistanim.ui.main.MainPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory { (view: MainContract.View) ->  MainPresenter(view) }
    //factory { (view: LoginContract.View) ->  LoginPresenter(view, get()) }

}