package com.example.ilactakipasistanim.ui.main.splash

import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SplashFragment : BaseFragment<SplashPresenter>(),SplashContract.View {

    override val layoutId: Int = R.layout.fragment_splash

    override val presenter: SplashPresenter by inject {
        parametersOf(this)
    }

    override fun initializeUI() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
