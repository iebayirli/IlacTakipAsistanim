package com.example.ilactakipasistanim.ui.main.medicines

import android.content.Intent
import android.provider.Settings
import androidx.core.content.ContextCompat.startActivity
import com.example.ilactakipasistanim.common.validator.BaseValidator
import com.example.ilactakipasistanim.common.validator.EmptyValidator
import com.example.ilactakipasistanim.ui.base.BasePresenter
import com.example.ilactakipasistanim.ui.enabiz_connection.EnabizActivity
import kotlinx.coroutines.*

class MedicinesPresenter(view : MedicinesContract.View) : BasePresenter<MedicinesContract.View>(view),
            MedicinesContract.Presenter{


    override fun inputControl(
        ilacAdi: String,
        kullanimSekli: String,
        baslangicTarihi: String,
        kullanımAdedi: String
    ) {
        var result = BaseValidator.validate(
            EmptyValidator(ilacAdi),
            EmptyValidator(kullanimSekli),
            EmptyValidator(baslangicTarihi),
            EmptyValidator(kullanımAdedi)
        )
        if(result.isSuccess){
            CoroutineScope(Dispatchers.IO).launch{

                view?.saveManuelAddedMedicines(ilacAdi,kullanimSekli,baslangicTarihi,kullanımAdedi)
                view?.saveListToShared()

                withContext(Dispatchers.Main){
                    view?.initRecyclerView()
                    view?.succeedDismissDialog()
                }

            }
        }else{
            view?.toast(result.message)
        }
    }

    override fun initList(isTrue: Boolean) {

        CoroutineScope(Dispatchers.IO).launch {

            view?.initList(isTrue)

            launch(Dispatchers.Main) {
                view?.initRecyclerView()
            }
        }
    }

    override fun deleteMedicineFromList(index: Int) {

        CoroutineScope(Dispatchers.IO).launch {

            view?.deleteMedicine(index)

            withContext(Dispatchers.Main){
                view?.saveListToShared()
                view?.initRecyclerView()
            }
        }
    }

    override fun addAlarmClicked() {
        view?.openAlarmActivity()
    }

}