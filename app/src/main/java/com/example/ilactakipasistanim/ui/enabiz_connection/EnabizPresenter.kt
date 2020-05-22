package com.example.ilactakipasistanim.ui.enabiz_connection


import com.app.uh1l.model.StatusResponse
import com.example.ilactakipasistanim.common.MedicinesClass
import com.example.ilactakipasistanim.common.validator.BaseValidator
import com.example.ilactakipasistanim.common.validator.EmptyValidator
import com.example.ilactakipasistanim.common.validator.TcNoValidator
import com.example.ilactakipasistanim.model.enabiz.EnabizRequest
import com.example.ilactakipasistanim.model.enabiz.Medicines
import com.example.ilactakipasistanim.rest.EnabizLoginService
import com.example.ilactakipasistanim.ui.base.BasePresenter
import kotlinx.coroutines.*

import org.koin.core.inject

class EnabizPresenter(view : EnabizContract.View): BasePresenter<EnabizContract.View>(view),
            EnabizContract.Presenter {

    private val loginService : EnabizLoginService by inject()
    val TIMEOUT = 50000L

    private val medicinesList = ArrayList<MedicinesClass>()

    override fun login(tcNo: String, sifre: String) {
        var result = BaseValidator.validate(
            EmptyValidator(tcNo),
            EmptyValidator(sifre),
            TcNoValidator(tcNo)
        )
        if(result.isSuccess){
            view?.showProgress()
            CoroutineScope(Dispatchers.IO).launch {

                val response = withTimeoutOrNull(TIMEOUT){
                    loginService.login(EnabizRequest(tcNo,sifre))
                }

                withContext(Dispatchers.Main){
                    view?.dismissProgress()
                    if(response?.statusCode?.id==0){
                        response.data.forEach {
                            var medicine =  MedicinesClass(
                                it.ilacAdi,
                                it.kullanimSekli,
                                it.receteTarihi,
                                it.kullanimSayisi,
                                it.hastaneAdi,
                                true
                            )
                            medicinesList.add(medicine)
                        }
                        view?.saveListToShared(medicinesList)

                    }else{
                        view?.toast("Bir Hata Oluştu Lütfen Tekrar Deneyin.")
                    }
                }
            }
        }else{
            view?.toast(result.message)
        }
    }

    override fun successAdded() {
        view?.toast("İlaçlarınız Başarıyla Eklendi.")
        view?.goToMain()
    }

    override fun registerClicked() {
        view?.openBrowser()
    }

}