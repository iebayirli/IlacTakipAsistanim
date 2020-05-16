package com.example.ilactakipasistanim.ui.main

import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.ui.base.BaseActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity<MainPresenter>(),MainContract.View {

    override val presenter : MainPresenter by inject {
            parametersOf(this)
    }
    override val layoutId: Int = R.layout.activity_main

    override fun initiliazeUI() {

    }
}