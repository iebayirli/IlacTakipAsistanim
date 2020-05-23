package com.example.ilactakipasistanim.ui.main.home

import android.view.View
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.common.AlarmsClass
import com.example.ilactakipasistanim.common.SharedPrefKey
import com.example.ilactakipasistanim.ui.base.BaseFragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : BaseFragment<HomePresenter>(), HomeContract.View {

    override val layoutId: Int = R.layout.fragment_home
    override val presenter: HomePresenter by inject {
        parametersOf(this)
    }

    private var alarmList = ArrayList<String>()

    override fun initializeUI() {
        val isim =baseActivity?.sharedPrefHelper?.getString(SharedPrefKey.NAME)
        val soyisim =baseActivity?.sharedPrefHelper?.getString(SharedPrefKey.SURNAME)
        val yas =baseActivity?.sharedPrefHelper?.getString(SharedPrefKey.AGE)
        val endeks =baseActivity?.sharedPrefHelper?.getString(SharedPrefKey.ENDEKS)

        text_view_ad.text = isim
        text_view_soyad.text = soyisim
        text_view_yas.text = yas
        text_view_endeks.text = endeks


        var isTrue = baseActivity?.sharedPrefHelper?.getBoolean(SharedPrefKey.INIT_ALARM_LIST)?:false
        if(isTrue){

            presenter.initAlarmList(isTrue)

            presenter.calculateTime(alarmList)

        }else{
            presenter.initAlarmList(isTrue)
        }



    }

    override fun initAlarmList(isTrue: Boolean) {
        if(isTrue){
            alarmList.addAll(baseActivity?.sharedPrefHelper?.getAlarmList(SharedPrefKey.ALARMS_LIST)!!)
        }else{
            home_text.text="Kurulu Alarmınız Bulunmamaktadır."
            mainScreenCircle.visibility= View.GONE
            kalanVakitText.visibility=View.GONE
            tmpHome.visibility=View.GONE
        }
    }

    override fun setUI(alarm: String) {
        mainScreenCircle.visibility= View.VISIBLE
        kalanVakitText.visibility=View.VISIBLE
        tmpHome.visibility=View.VISIBLE

        var vakit = alarm.substring(0,alarm.indexOf(";"))
        var ilacAdi = alarm.substring(alarm.indexOf(";")+1)

        var saat = vakit.substring(0,vakit.indexOf(":"))
        var dakika = vakit.substring(vakit.indexOf(":")+1)

        saat_text.text = saat
        dakika_text.text=dakika

        home_text.text = ilacAdi+" İlacın Vakti Geliyor"


    }



}
