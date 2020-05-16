package com.example.ilactakipasistanim.ui.onboarding

import com.example.ilactakipasistanim.ui.base.BaseView
import com.example.ilactakipasistanim.ui.onboarding.adapter.OnboardingData

class OnboardingContract {

    interface View : BaseView{
        fun nextPage(index: Int)
        fun configureButton(isLastPage: Boolean)
        fun finishOnBoarding()
    }
    interface Presenter{
        fun getOnboardingData(): List<OnboardingData>
        fun nextClicked(currentItem: Int)
        fun pageSelected(position: Int)
    }
}