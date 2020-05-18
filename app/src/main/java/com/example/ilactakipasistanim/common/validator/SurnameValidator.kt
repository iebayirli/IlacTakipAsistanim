package com.example.ilactakipasistanim.common.validator

class SurnameValidator(val text : String) : BaseValidator() {
    override fun validate(): ValidateResult {
        val isValid = text.contains(" ")
        return ValidateResult(isValid,if(!isValid) " " else "Geçerli bir soy isim girin")
    }
}