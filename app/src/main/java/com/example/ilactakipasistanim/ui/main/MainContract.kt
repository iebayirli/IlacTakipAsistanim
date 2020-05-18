package com.example.ilactakipasistanim.ui.main

import com.example.ilactakipasistanim.ui.base.BaseView

class MainContract {

    interface View: BaseView{
        fun showMedicinesFragment()
    }
    interface Presenter {
        fun onMecidinesClicked()
    }
}