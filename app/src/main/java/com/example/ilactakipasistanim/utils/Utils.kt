package com.example.ilactakipasistanim.utils

import android.app.Activity
import android.util.DisplayMetrics
import android.view.View
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout

object Utils {

    fun calculateRowItemSize(
        cardView: ConstraintLayout,
        activity: Activity
    ) {
        cardView.layoutParams.width =
            (getDeviceDimensions(activity)!!.widthPixels * 0.9f).toInt()
        cardView.layoutParams.height = cardView.layoutParams.width * 12 / 20
    }
    fun calculateLetterItemSize(
        cardView: ConstraintLayout,
        activity: Activity
    ) {
        cardView.layoutParams.width =
            (getDeviceDimensions(activity)!!.widthPixels * 0.41).toInt()
        cardView.layoutParams.height = cardView.layoutParams.width * 12 / 18
    }

    fun getDeviceDimensions(activity: Activity): DisplayMetrics? {
        val metrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(metrics)
        return metrics
    }
}