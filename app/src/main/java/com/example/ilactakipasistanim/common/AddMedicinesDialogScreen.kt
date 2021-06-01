package com.example.ilactakipasistanim.common

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.ilactakipasistanim.R
import kotlinx.android.synthetic.main.item_add_medicines.view.*

class AddMedicinesDialogScreen(val context: Context, layoutInflater: LayoutInflater) {

    private var dialog: Dialog = Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen)

    init {
        val view = layoutInflater.inflate(R.layout.item_add_medicines, null)
        dialog.setContentView(view)


        dialog.window?.run {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val width =
                (Resources.getSystem().displayMetrics.widthPixels * WIDTH_PERCENTAGE).toInt()
            setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT)
            setGravity(Gravity.CENTER)
        }

        view.close_window.setOnClickListener {
            dismissLetterDialog()
        }
        view.ilac_ekle_iptal_button.setOnClickListener {
            dismissLetterDialog()
        }
    }

    fun showLetterDialog() {
        dialog.show()
    }

    fun dismissLetterDialog() {
        dialog.dismiss()
    }

    fun isShowing(): Boolean {
        return dialog.isShowing
    }

    companion object {
        private const val WIDTH_PERCENTAGE = 0.8
    }
}