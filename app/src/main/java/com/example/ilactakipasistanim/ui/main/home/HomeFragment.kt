package com.example.ilactakipasistanim.ui.main.home

import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.common.SharedPrefKey
import com.example.ilactakipasistanim.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HomeFragment : BaseFragment<HomePresenter>(), HomeContract.View {

    override val layoutId: Int = R.layout.fragment_home
    override val presenter: HomePresenter by inject {
        parametersOf(this)
    }

    override fun initializeUI() {
        val isim =baseActivity?.sharedPrefHelper?.getString(SharedPrefKey.NAME)
        val soyisim =baseActivity?.sharedPrefHelper?.getString(SharedPrefKey.SURNAME)
        val yas =baseActivity?.sharedPrefHelper?.getString(SharedPrefKey.AGE)
        val endeks =baseActivity?.sharedPrefHelper?.getString(SharedPrefKey.ENDEKS)

        text_view_ad.text = isim
        text_view_soyad.text = soyisim
        text_view_yas.text = yas
        text_view_endeks.text = endeks
    }
}
