package com.example.ilactakipasistanim.ui.main

import android.view.View
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.ui.base.BaseActivity
import com.example.ilactakipasistanim.ui.main.alarms.AlarmsFragment
import com.example.ilactakipasistanim.ui.main.home.HomeFragment
import com.example.ilactakipasistanim.ui.main.medicines.MedicinesFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(),MainContract.View {

    override val presenter : MainPresenter by inject {
            parametersOf(this)
    }
    override val layoutId: Int = R.layout.activity_main

    override fun initiliazeUI() {

        init()

        close_button.setOnClickListener {
            init()
        }
        medicinesButton.setOnClickListener {
            presenter.onMecidinesClicked()
        }
        alarmButton.setOnClickListener {
            presenter.onAlarmsClicked()
        }
        router_button_home.setOnClickListener {
            init()
        }

    }

    override fun showMedicinesFragment() {
        close_button.visibility=View.VISIBLE
        constLayout.visibility=View.GONE
        toolbarHeaderText.text = "İlaçlarım"
        guideline2.setGuidelinePercent(0.085f)
        guideline1.setGuidelinePercent(0.14f)
        navigateFragment<MedicinesFragment>(R.id.fragmentContainer)
    }

    override fun showAlarmsFragment() {
        close_button.visibility=View.VISIBLE
        constLayout.visibility=View.GONE
        toolbarHeaderText.text = "Alarmlarım"
        guideline2.setGuidelinePercent(0.085f)
        guideline1.setGuidelinePercent(0.14f)
        navigateFragment<AlarmsFragment>(R.id.fragmentContainer)
    }

    private fun init(){
        close_button.visibility=View.GONE
        constLayout.visibility=View.VISIBLE
        toolbarHeaderText.text = "İlaç Takip Asistanım"
        guideline2.setGuidelinePercent(0.11f)
        guideline1.setGuidelinePercent(0.19f)

        navigateFragment<HomeFragment>(R.id.fragmentContainer)
    }
}