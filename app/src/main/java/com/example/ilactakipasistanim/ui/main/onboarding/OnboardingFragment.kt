package com.example.ilactakipasistanim.ui.main.onboarding

import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.ui.base.BaseFragment
import com.example.ilactakipasistanim.ui.base.BasePresenter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class OnboardingFragment : BaseFragment<OnboardingPresenter>(),OnboardingContract.View {

    override val layoutId: Int = R.layout.fragment_onboarding
    override val presenter: OnboardingPresenter by inject {
        parametersOf(this)
    }

    override fun initializeUI() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
