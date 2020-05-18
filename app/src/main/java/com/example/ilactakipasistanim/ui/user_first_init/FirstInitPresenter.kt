package com.example.ilactakipasistanim.ui.user_first_init

import com.example.ilactakipasistanim.common.validator.BaseValidator
import com.example.ilactakipasistanim.common.validator.EmptyValidator
import com.example.ilactakipasistanim.common.validator.NumberValidator
import com.example.ilactakipasistanim.ui.base.BasePresenter

class FirstInitPresenter(view : FirstInitContract.View) : BasePresenter<FirstInitContract.View>(view),
            FirstInitContract.Presenter{


    override fun firstInıt(name: String, surname: String, age: String, height: String, weight: String) {
        val result = BaseValidator.validate(
            EmptyValidator(name),
            EmptyValidator(surname),
            EmptyValidator(age),
            EmptyValidator(height),
            NumberValidator(age ,"yaş"),
            NumberValidator(weight ,"kilo"),
            NumberValidator(height,"boy")
        )
        if(result.isSuccess){
            view?.initSucceed(name,surname,age,indeksHesapla(height,weight))
        }else{
            view?.toast(result.message)
        }
    }

    private fun indeksHesapla(boy : String , kilo: String) : String{
        var hBoy = boy.toFloat()
        var wKilo = kilo.toFloat()

        var sonuc = wKilo/((hBoy / 100) * (hBoy / 100))
        return sonuc.toString()
    }
}