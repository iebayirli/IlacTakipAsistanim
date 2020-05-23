package com.example.ilactakipasistanim.ui.main.alarms

import com.example.ilactakipasistanim.common.AlarmsClass
import com.example.ilactakipasistanim.ui.base.BaseView

class AlarmsContract {

    interface View : BaseView {
        fun initList(isTrue : Boolean)
        fun initRecyclerView()
        fun deleteAlarm(index : Int )
        fun deleteAlarmFromListAndSaveShared(index : Int)
    }
    interface Presenter {
        fun initList(isTrue : Boolean)
        fun onAlarmDeleteClick(index : Int )
        fun alarmDeleted(index: Int)
    }
}