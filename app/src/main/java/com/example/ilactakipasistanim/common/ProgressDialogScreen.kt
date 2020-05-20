package com.example.ilactakipasistanim.common

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import com.example.ilactakipasistanim.R

class ProgressDialogScreen(val context: Context, val inflater: LayoutInflater) {

    private var dialog : Dialog = Dialog(context,android.R.style.Theme_Black)

    init {
        val view = inflater.inflate(R.layout.item_loading_screen, null)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawableResource(R.color.transparent)
        dialog.setContentView(view)

    }
    fun showProgressDialog(){
        dialog.show()
    }
    fun dismissProgressDialog(){
        dialog.dismiss()
    }

    fun isShowing(): Boolean {
        return dialog.isShowing
    }
}