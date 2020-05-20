package com.example.ilactakipasistanim.common.validator

class TcNoValidator (val text : String ) : BaseValidator() {
    override fun validate(): ValidateResult {
        var isValid = text.length == 11
        return ValidateResult(isValid,if(isValid) "" else "Kimlik numaranız eksik veya fazla.")
    }
}