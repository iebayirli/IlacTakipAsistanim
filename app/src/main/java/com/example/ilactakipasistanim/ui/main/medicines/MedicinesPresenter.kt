package com.example.ilactakipasistanim.ui.main.medicines

import com.example.ilactakipasistanim.common.validator.BaseValidator
import com.example.ilactakipasistanim.common.validator.EmptyValidator
import com.example.ilactakipasistanim.ui.base.BasePresenter

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
            view?.saveManuelAddedMedicines(ilacAdi,kullanimSekli,baslangicTarihi,kullanımAdedi)
            view?.succeedDismissDialog()
        }else{
            view?.toast(result.message)
        }
    }

}