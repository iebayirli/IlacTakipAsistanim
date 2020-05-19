package com.example.ilactakipasistanim.ui.main.medicines

import com.example.ilactakipasistanim.ui.base.BaseView

class MedicinesContract {

    interface View : BaseView{
        fun saveManuelAddedMedicines(ilacAdi : String,
                                     kullanimSekli : String,
                                     baslangicTarihi : String,
                                     kullanımAdedi: String)
        fun succeedDismissDialog()
    }
    interface Presenter {
        fun inputControl(ilacAdi : String,
                         kullanimSekli : String,
                         baslangicTarihi : String,
                         kullanımAdedi: String)
    }
}