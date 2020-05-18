package com.example.ilactakipasistanim.ui.splash

import android.content.Intent
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.common.SharedPrefKey
import com.example.ilactakipasistanim.ui.base.BaseActivity
import com.example.ilactakipasistanim.ui.main.MainActivity
import com.example.ilactakipasistanim.ui.onboarding.OnboardingActivity
import com.example.ilactakipasistanim.ui.user_first_init.FirstInitActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SplashActivity :BaseActivity<SplashPresenter>(),SplashContract.View {

    override val presenter: SplashPresenter by inject {
        parametersOf(this)
    }

    override val layoutId: Int = R.layout.activity_splash

    override fun initiliazeUI() {

    }

    override fun timeIsUp() {
        val isOnBoardingShowed =sharedPrefHelper?.getBoolean(SharedPrefKey.IS_ON_BOARDING_SHOWED) ?: false
        val isFirstInitDone = sharedPrefHelper?.getBoolean(SharedPrefKey.IS_ON_BOARDING_SHOWED)?:false
        if(isOnBoardingShowed and isFirstInitDone){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else if(isOnBoardingShowed and !isFirstInitDone){
            val intent = Intent(this , FirstInitActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}