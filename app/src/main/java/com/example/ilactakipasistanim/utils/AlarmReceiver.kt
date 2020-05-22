package com.example.ilactakipasistanim.utils

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.ilactakipasistanim.R

class AlarmReceiver : BroadcastReceiver() {

    companion object{
        lateinit var ringtone: Ringtone
        lateinit var notificationID : String
    }

    override fun onReceive(context: Context?, intent: Intent?) {

        setRingtone(context)
        var id = intent?.getStringExtra("ilac")

        var ilacAdi = id?.substring(0,id?.indexOf(":"))

        notificationID = id!!.substring(id!!.indexOf(":")+1)

        var intentClose = Intent(context, CloseNotificationReceiver::class.java)
        var stopIntent = PendingIntent.getBroadcast(context,notificationID.toInt(),intentClose,0)

        var builder = NotificationCompat.Builder(context!!, notificationID)
            .setSmallIcon(R.drawable.splash_app_icon)
            .setContentTitle("İlaç Takip Asistanım")
            .setContentText(ilacAdi+" Kullanma Vaktin Geldi!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(R.drawable.notification_alarm_icon,"Alarmı Durdur",stopIntent)

        var manager = NotificationManagerCompat.from(context)
        manager.notify(notificationID!!.toInt(),builder.build())

        Toast.makeText(context,"İlac Adi" + ilacAdi, Toast.LENGTH_LONG).show()

        ringtone.play()
    }
    private fun setRingtone(context: Context?){
        var alarmMelodi = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)

        if(alarmMelodi == null){

            alarmMelodi = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }
        ringtone = RingtoneManager.getRingtone(context,alarmMelodi)
    }
}