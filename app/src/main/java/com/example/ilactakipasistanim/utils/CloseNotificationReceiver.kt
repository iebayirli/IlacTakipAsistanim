package com.example.ilactakipasistanim.utils

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationManagerCompat
import com.example.ilactakipasistanim.utils.AlarmReceiver.Companion.notificationID
import com.example.ilactakipasistanim.utils.AlarmReceiver.Companion.ringtone

class CloseNotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        ringtone.stop()
        var notificationManager = NotificationManagerCompat.from(context!!)

        notificationManager.cancel(notificationID.toInt())


    }
}