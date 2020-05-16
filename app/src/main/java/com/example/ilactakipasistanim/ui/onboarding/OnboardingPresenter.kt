package com.example.ilactakipasistanim.ui.onboarding

import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.ui.base.BasePresenter
import com.example.ilactakipasistanim.ui.onboarding.adapter.OnboardingData

class OnboardingPresenter(view : OnboardingContract.View ): BasePresenter<OnboardingContract.View>(view),
            OnboardingContract.Presenter{





    override fun getOnboardingData(): List<OnboardingData> {
        return listOf(
            OnboardingData(
                "İlaç Takip Asistanım Uygulamasına\nHoşgeldiniz!",
                "Bu uygulama sizlere ilaç kullanım zamanlarınızda\nyardımcı olmaktadır.",
                R.drawable.onboarding_1,
                false
            ),
            OnboardingData(
                    "İster E-Nabız üyeliğini gir\nistersen kendin ekle ve ilaçlarını gör!",
                    "",
                    R.drawable.onboarding_4,
                false
            ),
            OnboardingData(
                    "Hatırlatıcılar sayesinde\nilaç zamanlarını kaçırma!",
                "",
                R.drawable.onboarding_5,
                false
            )


        )
    }

    override fun nextClicked(currentItem: Int) {
        if (currentItem < 2){
            view?.nextPage(currentItem + 1)
        } else {
            view?.finishOnBoarding()
        }
    }

    override fun pageSelected(position: Int) {
        view?.configureButton(position == 2)
    }
}