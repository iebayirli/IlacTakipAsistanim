package com.example.ilactakipasistanim.ui.enabiz_connection

import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.rest.EnabizLoginService
import com.example.ilactakipasistanim.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_enabiz.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class EnabizActivity : BaseActivity<EnabizPresenter>(),EnabizContract.View {

    override val presenter: EnabizPresenter by inject {
        parametersOf(this)
    }


    override val layoutId: Int = R.layout.activity_enabiz

    override fun initiliazeUI() {

        enabiz_giris_button.setOnClickListener {
            var tcNo = edit_text_tc_no.text.toString()
            var sifre = edit_text_sifre.text.toString()

            presenter.login(tcNo,sifre)
        }
    }

    private fun getUser(){

    }

}