package com.example.ilactakipasistanim.ui.set_alarm

import com.example.ilactakipasistanim.ui.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class SetAlarmPresenter(view : SetAlarmContract.View) : BasePresenter<SetAlarmContract.View>(view),
            SetAlarmContract.Presenter{

    override fun initMedicine() {
        CoroutineScope(Dispatchers.IO).launch {

            view?.getMedicineFromShared()

            withContext(Dispatchers.Main){
                view?.setMedicineToUI()
            }
        }
    }

    override fun iptalClicked() {
        view?.startMain()
    }

    override fun calculateAlarmTimes(baslangicSaati: String, kullanimAdedi: Int){

        CoroutineScope(Dispatchers.IO).launch {

            var list = calculateTimes(baslangicSaati,kullanimAdedi)

            withContext(Dispatchers.Main){
                view?.getAlarmTimes(list)
                view?.setCalculatedAlarms()
            }
        }
    }

    override fun getFirstAlarm() {
        view?.setTimePickerDialog()
    }

    override fun setAlarmClicked() {
        view?.setAlarm()
    }

    override fun alarmSetted() {
        view?.toast("Alarm Ayarlandı")
        view?.saveAlarmListToShared()
    }

    private fun calculateTimes(baslangicSaati: String, kullanimAdedi: Int) : ArrayList<String>{

        var liste = ArrayList<String>()
        var aralik : String = "00:00"
        var timeFormat = SimpleDateFormat("HH:mm")
        timeFormat.timeZone = TimeZone.getTimeZone("GMT")


        when(kullanimAdedi){
            2 -> aralik = "12:00"
            3,4 -> aralik = "0"+(24/kullanimAdedi).toString()+":"+"00"
        }

        var baslangic = timeFormat.parse(baslangicSaati)
        var addedTime = timeFormat.parse(aralik)

        for(i in kullanimAdedi downTo 1){
            var sum = baslangic.time + addedTime.time
            var date3 = timeFormat.format(Date(sum))
            baslangic = timeFormat.parse(date3)
            liste.add(date3)
        }
        return liste
    }

}