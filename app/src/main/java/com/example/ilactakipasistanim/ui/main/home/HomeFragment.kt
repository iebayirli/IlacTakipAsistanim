package com.example.ilactakipasistanim.ui.main.home

import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HomeFragment : BaseFragment<HomePresenter>(), HomeContract.View {

    override val layoutId: Int = R.layout.fragment_home
    override val presenter: HomePresenter by inject {
        parametersOf(this)
    }

    override fun initializeUI() {

    }
}
