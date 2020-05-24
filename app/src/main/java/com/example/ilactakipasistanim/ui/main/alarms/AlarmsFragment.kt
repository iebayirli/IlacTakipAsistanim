package com.example.ilactakipasistanim.ui.main.alarms

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.common.AlarmsClass
import com.example.ilactakipasistanim.common.SharedPrefKey
import com.example.ilactakipasistanim.ui.base.BaseFragment
import com.example.ilactakipasistanim.ui.main.alarms.adapter.AlarmViewItemClickListener
import com.example.ilactakipasistanim.ui.main.alarms.adapter.AlarmsAdapter
import com.example.ilactakipasistanim.receivers.AlarmReceiver
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_alarms.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class AlarmsFragment : BaseFragment<AlarmsPresenter>(), AlarmsContract.View , AlarmViewItemClickListener{

    override val layoutId: Int = R.layout.fragment_alarms

    override val presenter: AlarmsPresenter by inject {
        parametersOf(this)
    }
    private var alarmList = ArrayList<String>()
    lateinit var alarmManager : AlarmManager
    lateinit var notificationManager: NotificationManager

    override fun initializeUI() {

        alarm_recyclerview.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)

        alarmManager=  context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        var isTrue = baseActivity?.sharedPrefHelper?.getBoolean(SharedPrefKey.INIT_ALARM_LIST)?:false
        if(isTrue){
            presenter.initList(isTrue)
        }else{
            presenter.initList(isTrue)
        }

    }

    override fun initList(isTrue: Boolean) {
        if(isTrue){
            alarmList.addAll(baseActivity?.sharedPrefHelper?.getAlarmList(SharedPrefKey.ALARMS_LIST)!!)
        }
    }

    override fun initRecyclerView() {
        if(alarmList.isNullOrEmpty()){
            alarminiz_bulunmamakta.visibility=View.VISIBLE
            alarminiz_bulunmamakta.text="Hiç Alarmınız Bulunmamakta"
            alarm_recyclerview.visibility=View.GONE
            baseActivity?.sharedPrefHelper?.saveBoolean(SharedPrefKey.INIT_ALARM_LIST,false)
        }else{
            alarminiz_bulunmamakta.visibility=View.GONE
            alarm_recyclerview.visibility=View.VISIBLE
            alarm_recyclerview.adapter = AlarmsAdapter(alarmList,baseActivity!!,this)
        }
    }

    override fun onAlarmClicked(index: Int) {
        presenter.onAlarmDeleteClick(index)
    }
    override fun deleteAlarm(index: Int) {
        var alarm = Gson().fromJson(alarmList[index],AlarmsClass::class.java)

        alarm.ids.forEach {id ->
            var intent = Intent(context,
                AlarmReceiver::class.java)
            var pendingIntent = PendingIntent.getBroadcast(context,id.toInt(),intent,0)

            alarmManager.cancel(pendingIntent)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.deleteNotificationChannel(id)
            }
        }
        presenter.alarmDeleted(index)
    }
    override fun deleteAlarmFromListAndSaveShared(index: Int) {
        alarmList.removeAt(index)
        baseActivity?.sharedPrefHelper?.saveAlarmList(SharedPrefKey.ALARMS_LIST,alarmList)
    }

}