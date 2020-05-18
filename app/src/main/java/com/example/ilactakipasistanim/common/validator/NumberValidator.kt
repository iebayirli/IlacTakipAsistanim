package com.example.ilactakipasistanim.common.validator

class NumberValidator(val text : String, val editTextType : String ) : BaseValidator(){
    override fun validate(): ValidateResult {
        val isValid = text.length ==2 || text.length == 3
        return ValidateResult(isValid,if(isValid) "" else "Geçerli bir $editTextType girin")
    }
}