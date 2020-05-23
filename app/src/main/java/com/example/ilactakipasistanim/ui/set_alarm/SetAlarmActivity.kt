package com.example.ilactakipasistanim.ui.set_alarm

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.common.MedicinesClass
import com.example.ilactakipasistanim.common.SharedPrefKey
import com.example.ilactakipasistanim.ui.base.BaseActivity
import com.example.ilactakipasistanim.ui.main.MainActivity
import com.example.ilactakipasistanim.utils.AlarmReceiver
import kotlinx.android.synthetic.main.activity_set_alarm.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class SetAlarmActivity : BaseActivity<SetAlarmPresenter>(), SetAlarmContract.View {

    override val presenter: SetAlarmPresenter by inject {
        parametersOf(this)
    }

    override val layoutId: Int = R.layout.activity_set_alarm

    lateinit var medicine: MedicinesClass

    lateinit var baslangicSaati : String

    private var alarmList = ArrayList<String>()
    private var idList = ArrayList<String>()

    lateinit var alarmManager : AlarmManager
    lateinit var notificationManager : NotificationManager

    private var notID : Int = 0

    override fun initiliazeUI() {

        presenter.initMedicine()

        alarmManager=  this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notificationManager = this.getSystemService(NotificationManager::class.java)
        }

        saat_sec_button.setOnClickListener {
            presenter.getFirstAlarm()
        }
        set_alarm_iptal.setOnClickListener {
            presenter.iptalClicked()
        }
        set_alarm_ekle.setOnClickListener {
            presenter.setAlarmClicked()
        }
    }

    override fun getMedicineFromShared() {
        medicine = sharedPrefHelper?.getAlarmMedicine(SharedPrefKey.ALARM_MEDICINE)
    }

    override fun setMedicineToUI() {
        if(medicine.isFromEnabiz){
            text_view_ilac_adi.text = medicine.ilacAdi
            text_view_baslangic_tarihi.text = medicine.baslangicTarihi
            text_view_kullanim_sekli.text = medicine.kullanimSekli
            text_view_kullanım_adedi.text = medicine.kullanimSayisi
            text_view_muayene_yeri.text = medicine.hastaneAdi
            imageViewLogo.visibility= View.VISIBLE
        }else{
            text_view_ilac_adi.text = medicine.ilacAdi
            text_view_baslangic_tarihi.text = medicine.baslangicTarihi
            text_view_kullanim_sekli.text = medicine.kullanimSekli
            text_view_kullanım_adedi.text = medicine.kullanimSayisi
            text_view_muayene_yeri.text = "Yok."
            imageViewLogo.visibility= View.GONE
        }
    }

    override fun startMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun getAlarmTimes(alarmListesi : ArrayList<String>){
         alarmList = alarmListesi
    }

    override fun setTimePickerDialog(){
        val calendar = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener{ timePicker , hour, minute ->
            calendar.set(Calendar.HOUR_OF_DAY,hour)
            calendar.set(Calendar.MINUTE,minute)
            text_view_baslangic_saati.text = SimpleDateFormat("HH:mm").format(calendar.time)
            baslangicSaati = SimpleDateFormat("HH:mm").format(calendar.time)
            presenter.calculateAlarmTimes(baslangicSaati,medicine.kullanimSayisi.toInt())
        }
        TimePickerDialog(this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
    }

    override fun setCalculatedAlarms() {
        var tmp = " "
        alarmList.forEach {
             tmp = tmp + "\n" + it
        }
        text_view_hesaplanan_saatler.text = tmp
    }

    override fun setAlarm() {

        alarmList.forEach { alarmSaati ->

            var saat = alarmSaati.substring(0,alarmSaati.indexOf(":"))
            var dakika = alarmSaati.substring(alarmSaati.indexOf(":")+1)
            var saniye= "00"


            notID = (System.currentTimeMillis()/1000).toInt()
            createNotificationChannel(notID.toString())

            var id = medicine.ilacAdi.trim()+":"+notID.toString()

            var intent = Intent(this, AlarmReceiver::class.java)
            intent.putExtra("ilac",id)
            var pendingIntent = PendingIntent.getBroadcast(this,notID,intent,0)

            var calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY,saat.toInt())
            calendar.set(Calendar.MINUTE,dakika.toInt())
            calendar.set(Calendar.SECOND, saniye.toInt())
            calendar.set(Calendar.MILLISECOND,saniye.toInt())

            var alarmTime = calendar.timeInMillis

            alarmManager?.setRepeating(AlarmManager.RTC_WAKEUP, alarmTime,AlarmManager.INTERVAL_DAY,pendingIntent)

        }
        presenter.alarmSetted()

    }
    private fun makeUniqueID() : String {
        return UUID.randomUUID().toString()
    }
    private fun createNotificationChannel(id : String){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            var channel = NotificationChannel(id,"ilacTakipAsistanim",importance)
            notificationManager.createNotificationChannel(channel)
        } else {

        }

    }

}