package com.example.ilactakipasistanim.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationManagerCompat
import com.example.ilactakipasistanim.receivers.AlarmReceiver.Companion.notificationID
import com.example.ilactakipasistanim.receivers.AlarmReceiver.Companion.ringtone

class CloseNotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        ringtone.stop()
        var notificationManager = NotificationManagerCompat.from(context!!)

        notificationManager.cancel(notificationID.toInt())


    }
}