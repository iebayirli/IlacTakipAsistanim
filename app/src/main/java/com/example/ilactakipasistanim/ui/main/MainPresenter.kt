package com.example.ilactakipasistanim.ui.main

import com.example.ilactakipasistanim.ui.base.BasePresenter

class MainPresenter(view : MainContract.View):BasePresenter<MainContract.View>(view),
            MainContract.Presenter{


    override fun onMecidinesClicked() {
        view?.showMedicinesFragment()
    }

    override fun onAlarmsClicked() {
        view?.showAlarmsFragment()
    }


}