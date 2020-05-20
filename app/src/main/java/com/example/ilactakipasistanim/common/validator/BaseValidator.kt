package com.example.ilactakipasistanim.common.validator


abstract class BaseValidator: IValidator {
    companion object {
        fun validate(vararg validators: IValidator): ValidateResult {
            validators.forEach {
                val result = it.validate()
                if (!result.isSuccess)
                    return result
            }
            return ValidateResult(true, "")
        }
    }
}