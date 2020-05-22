package com.example.ilactakipasistanim.utils

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.widget.Toast
import com.example.ilactakipasistanim.R

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        var id = intent?.getStringExtra("ilac")

        var ilacAdi = id?.substring(0,id?.indexOf(":"))

        Toast.makeText(context,"İlac Adi" + ilacAdi, Toast.LENGTH_LONG).show()

        var alarmMelodi = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)

        if(alarmMelodi == null){

            alarmMelodi = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }
        var ringtone = RingtoneManager.getRingtone(context,alarmMelodi)
        ringtone.play()


    }
}