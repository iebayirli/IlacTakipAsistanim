package com.example.ilactakipasistanim.common

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import com.example.ilactakipasistanim.R
import kotlinx.android.synthetic.main.item_add_medicines.view.*

class AddMedicinesDialogScreen (val context: Context , layoutInflater: LayoutInflater) {

    private var dialog : Dialog = Dialog(context,android.R.style.Theme_Black_NoTitleBar_Fullscreen)

    init{
        var view = layoutInflater.inflate(R.layout.item_add_medicines,null)
        dialog.setContentView(view)
        dialog.window.setBackgroundDrawableResource(R.color.transparent)

        view.close_window.setOnClickListener {
            dismissLetterDialog()
        }
        view.ilac_ekle_iptal_button.setOnClickListener {
            dismissLetterDialog()
        }
    }

    fun showLetterDialog(){
        dialog.show()
    }
    fun dismissLetterDialog(){
        dialog.dismiss()
    }
    fun isShowing(): Boolean {
        return dialog.isShowing
    }
}