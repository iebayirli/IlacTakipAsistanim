package com.example.ilactakipasistanim.ui.set_alarm

import com.example.ilactakipasistanim.ui.base.BaseView

class SetAlarmContract {
    interface View: BaseView{
        fun getMedicineFromShared()
        fun setMedicineToUI()
        fun startMain()
        fun getAlarmTimes(alarmListesi : ArrayList<String>)
        fun setTimePickerDialog()
        fun setCalculatedAlarms()
        fun setAlarm()
    }
    interface Presenter{
        fun initMedicine()
        fun iptalClicked()
        fun calculateAlarmTimes(baslangicSaati : String , kullanimAdedi : Int)
        fun getFirstAlarm()
        fun setAlarmClicked()
        fun alarmSetted()
    }
}