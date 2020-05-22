package com.example.ilactakipasistanim.ui.main.medicines

import com.example.ilactakipasistanim.ui.base.BaseView

class MedicinesContract {

    interface View : BaseView{
        fun saveManuelAddedMedicines(ilacAdi : String,
                                     kullanimSekli : String,
                                     baslangicTarihi : String,
                                     kullanımAdedi: String)
        fun succeedDismissDialog()
        fun initList(isTrue : Boolean)
        fun initRecyclerView()
        fun saveListToShared()
        fun deleteMedicine(index : Int)
        fun openAlarmActivity()
    }
    interface Presenter {
        fun inputControl(ilacAdi : String,
                         kullanimSekli : String,
                         baslangicTarihi : String,
                         kullanımAdedi: String)
        fun initList(isTrue : Boolean)
        fun deleteMedicineFromList(index : Int)
        fun addAlarmClicked()
    }
}