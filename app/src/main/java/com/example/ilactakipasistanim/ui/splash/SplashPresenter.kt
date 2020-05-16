package com.example.ilactakipasistanim.ui.splash

import com.example.ilactakipasistanim.common.ApplicationConstant
import com.example.ilactakipasistanim.ui.base.BasePresenter
import kotlinx.coroutines.*

class SplashPresenter(view : SplashContract.View): BasePresenter<SplashContract.View>(view),
            SplashContract.Presenter{


    fun startTimer() {
        GlobalScope.launch(Dispatchers.IO) {
            delay(ApplicationConstant.SPLASH_DELAY_TIME)
            withContext(Dispatchers.Main) {
                if (isViewAlive.get())
                    view?.timeIsUp()
            }
        }
    }

    override fun start() {
        super.start()
        startTimer()
    }
}