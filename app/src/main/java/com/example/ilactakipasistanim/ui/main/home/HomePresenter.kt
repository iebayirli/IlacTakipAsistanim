package com.example.ilactakipasistanim.ui.main.home

import com.example.ilactakipasistanim.common.AlarmsClass
import com.example.ilactakipasistanim.ui.base.BaseFragment
import com.example.ilactakipasistanim.ui.base.BasePresenter
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class HomePresenter(view : HomeContract.View) : BasePresenter<HomeContract.View>(view),
            HomeContract.Presenter{
    override fun initAlarmList(isTrue: Boolean) {
        view?.initAlarmList(isTrue)
    }

    override fun calculateTime(alarmList: ArrayList<String>) {
        CoroutineScope(Dispatchers.IO).launch {
            var alarm =calculatedTime(alarmList)

            withContext(Dispatchers.Main){
                view?.setUI(alarm)
            }
        }
    }

    private fun calculatedTime(alarmList : ArrayList<String>) : String{
        var timeFormat = SimpleDateFormat("HH:mm")
        timeFormat.timeZone = TimeZone.getTimeZone("GMT")
        var currentTime = System.currentTimeMillis()

        var aalarm = Gson().fromJson(alarmList[0], AlarmsClass::class.java)
        var enKucuk = aalarm.alarmSaatleri[0]+";"+aalarm.medicine.ilacAdi

        alarmList.forEach {
            var medicine = Gson().fromJson(it, AlarmsClass::class.java)
            medicine.alarmSaatleri.forEach { alarmSaati ->
                var saat = timeFormat.parse(alarmSaati)
                var tmp = enKucuk.substring(0,enKucuk.indexOf(";"))
                var tmp2 = timeFormat.parse(tmp)

                var fark = saat.time - currentTime
                if(fark < tmp2.time ){
                    var date3 = timeFormat.format(Date(fark))
                    enKucuk = date3+";"+medicine.medicine.ilacAdi
                }
            }
        }
        return enKucuk
    }

}