package com.example.ilactakipasistanim.utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.example.ilactakipasistanim.utils.AlarmReceiver.Companion.notificationID
import com.example.ilactakipasistanim.utils.AlarmReceiver.Companion.ringtone

class StopAlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ringtone.stop()
        var notificationManager = NotificationManagerCompat.from(this)
        notificationManager.cancel(notificationID.toInt())
        finish()
    }
}