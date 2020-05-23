package com.example.ilactakipasistanim.ui.main.home

import com.example.ilactakipasistanim.ui.base.BaseView

class HomeContract {

    interface View : BaseView{
        fun initAlarmList(isTrue: Boolean)
        fun setUI(alarm:String)
    }
    interface Presenter {
        fun initAlarmList( isTrue: Boolean)
        fun calculateTime(alarmList : ArrayList<String>)
    }
}