package com.example.ilactakipasistanim.di


import com.example.ilactakipasistanim.ui.main.MainContract
import com.example.ilactakipasistanim.ui.main.MainPresenter
import com.example.ilactakipasistanim.ui.onboarding.OnboardingContract
import com.example.ilactakipasistanim.ui.onboarding.OnboardingPresenter
import com.example.ilactakipasistanim.ui.splash.SplashContract
import com.example.ilactakipasistanim.ui.splash.SplashPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory { (view: MainContract.View) ->  MainPresenter(view) }
    factory { (view: SplashContract.View) -> SplashPresenter(view)  }
    factory { (view: OnboardingContract.View) -> OnboardingPresenter(view)  }

}