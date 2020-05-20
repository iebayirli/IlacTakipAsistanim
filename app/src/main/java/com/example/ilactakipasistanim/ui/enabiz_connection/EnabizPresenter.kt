package com.example.ilactakipasistanim.ui.enabiz_connection


import com.app.uh1l.model.StatusResponse
import com.example.ilactakipasistanim.common.validator.BaseValidator
import com.example.ilactakipasistanim.common.validator.EmptyValidator
import com.example.ilactakipasistanim.common.validator.TcNoValidator
import com.example.ilactakipasistanim.model.enabiz.EnabizRequest
import com.example.ilactakipasistanim.rest.EnabizLoginService
import com.example.ilactakipasistanim.ui.base.BasePresenter
import kotlinx.coroutines.*

import org.koin.core.inject

class EnabizPresenter(view : EnabizContract.View): BasePresenter<EnabizContract.View>(view),
            EnabizContract.Presenter {

    private val loginService : EnabizLoginService by inject()

    override fun login(tcNo: String, sifre: String) {
        var result = BaseValidator.validate(
            EmptyValidator(tcNo),
            EmptyValidator(sifre),
            TcNoValidator(tcNo)
        )
        if(result.isSuccess){

            CoroutineScope(Dispatchers.Main).launch {

                var task = async(Dispatchers.IO) {
                    loginService.login(EnabizRequest(tcNo,sifre))
                }

                var response = task.await()


                if(response.statusCode.id==0){
                    view?.toast(response.statusCode.message +" " + response.data.data.size)
                }else{
                    view?.toast(response.statusCode.message)
                }

            }
        }else{
            view?.toast(result.message)
        }
    }

}