package com.example.ilactakipasistanim.common.validator

class EmptyValidator (val text : String ) : BaseValidator() {
    override fun validate(): ValidateResult {
        val isValid = !text.isNullOrEmpty()
        return ValidateResult(isValid,if(isValid) "" else "Boş alanları doldurun.")
    }
}