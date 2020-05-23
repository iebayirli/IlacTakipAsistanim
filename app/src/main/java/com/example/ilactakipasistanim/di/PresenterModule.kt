package com.example.ilactakipasistanim.di


import com.example.ilactakipasistanim.ui.enabiz_connection.EnabizContract
import com.example.ilactakipasistanim.ui.enabiz_connection.EnabizPresenter
import com.example.ilactakipasistanim.ui.main.MainContract
import com.example.ilactakipasistanim.ui.main.MainPresenter
import com.example.ilactakipasistanim.ui.main.alarms.AlarmsContract
import com.example.ilactakipasistanim.ui.main.alarms.AlarmsPresenter
import com.example.ilactakipasistanim.ui.main.home.HomeContract
import com.example.ilactakipasistanim.ui.main.home.HomePresenter
import com.example.ilactakipasistanim.ui.main.medicines.MedicinesContract
import com.example.ilactakipasistanim.ui.main.medicines.MedicinesPresenter
import com.example.ilactakipasistanim.ui.onboarding.OnboardingContract
import com.example.ilactakipasistanim.ui.onboarding.OnboardingPresenter
import com.example.ilactakipasistanim.ui.set_alarm.SetAlarmContract
import com.example.ilactakipasistanim.ui.set_alarm.SetAlarmPresenter
import com.example.ilactakipasistanim.ui.splash.SplashContract
import com.example.ilactakipasistanim.ui.splash.SplashPresenter
import com.example.ilactakipasistanim.ui.user_first_init.FirstInitContract
import com.example.ilactakipasistanim.ui.user_first_init.FirstInitPresenter
import org.koin.core.KoinComponent
import org.koin.dsl.module

val presenterModule = module {
    factory { (view: MainContract.View) ->  MainPresenter(view) }
    factory { (view: SplashContract.View) -> SplashPresenter(view)  }
    factory { (view: OnboardingContract.View) -> OnboardingPresenter(view) }
    factory { (view: FirstInitContract.View) -> FirstInitPresenter(view)  }
    factory { (view: HomeContract.View) -> HomePresenter(view)  }
    factory { (view: MedicinesContract.View) -> MedicinesPresenter(view)  }
    factory { (view: EnabizContract.View) -> EnabizPresenter(view)   }
    factory { (view: SetAlarmContract.View) -> SetAlarmPresenter(view)   }
    factory { (view : AlarmsContract.View) -> AlarmsPresenter(view) }

}