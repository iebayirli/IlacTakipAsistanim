package com.example.ilactakipasistanim.ui.user_first_init

import android.content.Intent
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.common.SharedPrefKey
import com.example.ilactakipasistanim.ui.base.BaseActivity
import com.example.ilactakipasistanim.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_user_first_init.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class FirstInitActivity :BaseActivity<FirstInitPresenter>(), FirstInitContract.View {


    override val presenter: FirstInitPresenter by inject {
        parametersOf(this)
    }
    override val layoutId: Int = R.layout.activity_user_first_init

    override fun initiliazeUI() {
        first_init_finish_button.setOnClickListener {
            val name = edit_text_isim.text.toString()
            val surname= edit_text_soyisim.text.toString()
            val age = edit_text_yas.text.toString()
            val boy = edit_text_boy.text.toString()
            val kilo = edit_text_kilo.text.toString()

            presenter.firstInıt(name,surname,age,boy,kilo)
        }
    }

    override fun initSucceed(name: String, surname: String, age: String, indeks: String) {
        sharedPrefHelper.saveString(SharedPrefKey.NAME,name)
        sharedPrefHelper.saveString(SharedPrefKey.SURNAME,surname)
        sharedPrefHelper.saveString(SharedPrefKey.AGE,age)
        sharedPrefHelper.saveString(SharedPrefKey.ENDEKS,indeks)
        sharedPrefHelper.saveBoolean(SharedPrefKey.IS_FIRST_INIT_DONE,true)

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()

    }


}