package com.example.ilactakipasistanim.ui.enabiz_connection

import com.example.ilactakipasistanim.rest.EnabizLoginService
import com.example.ilactakipasistanim.ui.base.BaseView

class EnabizContract {
    interface View : BaseView{

    }
    interface Presenter{
        fun login(tcNo : String , sifre : String)
    }
}