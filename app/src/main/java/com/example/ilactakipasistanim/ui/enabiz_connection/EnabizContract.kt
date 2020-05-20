package com.example.ilactakipasistanim.ui.enabiz_connection

import com.example.ilactakipasistanim.common.MedicinesClass
import com.example.ilactakipasistanim.rest.EnabizLoginService
import com.example.ilactakipasistanim.ui.base.BaseView

class EnabizContract {
    interface View : BaseView{
        fun saveListToShared(medicinesList : ArrayList<MedicinesClass>)
        fun goToMain()
        fun openBrowser()
    }
    interface Presenter{
        fun login(tcNo : String , sifre : String)
        fun successAdded()
        fun registerClicked()
    }
}