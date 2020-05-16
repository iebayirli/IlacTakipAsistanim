package com.example.ilactakipasistanim.ui.onboarding

import android.content.Intent
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.common.SharedPrefKey
import com.example.ilactakipasistanim.ui.base.BaseActivity
import com.example.ilactakipasistanim.ui.main.MainActivity
import com.example.ilactakipasistanim.ui.onboarding.adapter.OnboardingAdapter
import kotlinx.android.synthetic.main.activity_onboarding.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class OnboardingActivity: BaseActivity<OnboardingPresenter>(), OnboardingContract.View {
    override val presenter: OnboardingPresenter by inject {
        parametersOf(this)
    }
    override val layoutId: Int = R.layout.activity_onboarding

    override fun initiliazeUI() {
        initViewPager()
    }

    override fun nextPage(index: Int) {
        viewPager.setCurrentItem(index, true)
    }

    override fun configureButton(isLastPage: Boolean) {
        if (isLastPage){
            buttonSkip.visibility = View.INVISIBLE
            buttonSkip.isEnabled = false
            buttonNext.text = "Başla"
        } else {
            buttonSkip.visibility = View.VISIBLE
            buttonSkip.isEnabled = true
        }
    }

    private fun initViewPager() {

        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val data = presenter?.getOnboardingData()

        viewPager.adapter = OnboardingAdapter(data!!)

        indicator.setViewPager(viewPager)

        buttonNext.setOnClickListener {
            val currentItem = viewPager.currentItem
            presenter?.nextClicked(currentItem)
        }

        buttonSkip.setOnClickListener {
            finishOnBoarding()
        }

        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                presenter?.pageSelected(position)
            }
        })
    }


    override fun finishOnBoarding() {
        sharedPrefHelper?.saveBoolean(SharedPrefKey.IS_ON_BOARDING_SHOWED,false)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }



}