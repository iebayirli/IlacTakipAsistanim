package com.example.ilactakipasistanim.ui.main

import android.view.View
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.ui.base.BaseActivity
import com.example.ilactakipasistanim.ui.main.home.HomeFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(),MainContract.View {

    override val presenter : MainPresenter by inject {
            parametersOf(this)
    }
    override val layoutId: Int = R.layout.activity_main

    override fun initiliazeUI() {
        navigateFragment<HomeFragment>(R.id.fragmentContainer)
    }

    override fun showSplashFragment() {
    }
}