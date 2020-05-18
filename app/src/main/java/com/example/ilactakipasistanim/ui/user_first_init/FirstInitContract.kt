package com.example.ilactakipasistanim.ui.user_first_init

import com.example.ilactakipasistanim.ui.base.BaseView

class FirstInitContract {

    interface View : BaseView {
        fun initSucceed(
            name: String,
            surname: String,
            age: String,
            indeks:String
        )
    }
    interface Presenter {
        fun firstInıt(
            name : String,
            surname : String,
            age : String,
            height : String,
            weight : String
        )
    }

}