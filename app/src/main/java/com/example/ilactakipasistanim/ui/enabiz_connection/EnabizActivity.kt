package com.example.ilactakipasistanim.ui.enabiz_connection

import android.content.Intent
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.common.MedicinesClass
import com.example.ilactakipasistanim.common.SharedPrefKey
import com.example.ilactakipasistanim.rest.EnabizLoginService
import com.example.ilactakipasistanim.ui.base.BaseActivity
import com.example.ilactakipasistanim.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_enabiz.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class EnabizActivity : BaseActivity<EnabizPresenter>(),EnabizContract.View {

    override val presenter: EnabizPresenter by inject {
        parametersOf(this)
    }

    private var tmp = ArrayList<MedicinesClass>()

    override val layoutId: Int = R.layout.activity_enabiz

    override fun initiliazeUI() {

        enabiz_giris_button.setOnClickListener {
            var tcNo = edit_text_tc_no.text.toString()
            var sifre = edit_text_sifre.text.toString()

            presenter.login(tcNo,sifre)
        }
        enabiz_iptal_button.setOnClickListener {
            startActivity(Intent( this, MainActivity::class.java))
        }

        textViewSignup.setOnClickListener{
            presenter.registerClicked()
        }
    }

    override fun saveListToShared(medicinesList: ArrayList<MedicinesClass>) {

        var ilkIlac = sharedPrefHelper?.getBoolean(SharedPrefKey.ILK_ILAC)?:false
        if(ilkIlac){
            medicinesList.addAll(sharedPrefHelper?.getManuelMedicines(SharedPrefKey.MANUEL_ADD_MEDICINES)!!)
            sharedPrefHelper?.saveManuelMedicines(SharedPrefKey.MANUEL_ADD_MEDICINES,medicinesList)
        }else{
            sharedPrefHelper?.saveManuelMedicines(SharedPrefKey.MANUEL_ADD_MEDICINES,medicinesList)
            sharedPrefHelper?.saveBoolean(SharedPrefKey.ILK_ILAC,true)
        }
        presenter.successAdded()

    }

    override fun goToMain() {
        startActivity(Intent( this, MainActivity::class.java))
    }

    override fun openBrowser() {
        openBrowser("https://enabiz.gov.tr/")
    }


}