package com.example.ilactakipasistanim.di


import com.example.ilactakipasistanim.ui.main.MainContract
import com.example.ilactakipasistanim.ui.main.MainPresenter
import com.example.ilactakipasistanim.ui.main.home.HomeContract
import com.example.ilactakipasistanim.ui.main.home.HomePresenter
import com.example.ilactakipasistanim.ui.main.medicines.MedicinesContract
import com.example.ilactakipasistanim.ui.main.medicines.MedicinesPresenter
import com.example.ilactakipasistanim.ui.onboarding.OnboardingContract
import com.example.ilactakipasistanim.ui.onboarding.OnboardingPresenter
import com.example.ilactakipasistanim.ui.splash.SplashContract
import com.example.ilactakipasistanim.ui.splash.SplashPresenter
import com.example.ilactakipasistanim.ui.user_first_init.FirstInitContract
import com.example.ilactakipasistanim.ui.user_first_init.FirstInitPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory { (view: MainContract.View) ->  MainPresenter(view) }
    factory { (view: SplashContract.View) -> SplashPresenter(view)  }
    factory { (view: OnboardingContract.View) -> OnboardingPresenter(view) }
    factory { (view: FirstInitContract.View) -> FirstInitPresenter(view)  }
    factory { (view: HomeContract.View) -> HomePresenter(view)  }
    factory { (view: MedicinesContract.View) -> MedicinesPresenter(view)  }

}