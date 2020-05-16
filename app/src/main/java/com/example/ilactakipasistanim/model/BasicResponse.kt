package com.app.uh1l.model

import com.google.gson.annotations.SerializedName

class BasicResponse() {
}

enum class BasicStatusType(val id: Int, val message: String){
    @SerializedName("0")
    SUCCESS(0, "Başarılı"),
    @SerializedName("1")
    FAILURE(1, "Hata"),
}

