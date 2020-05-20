package com.example.ilactakipasistanim.model.enabiz

import com.google.gson.annotations.SerializedName

data class EnabizResponse (@SerializedName("data") val data : ArrayList<Medicines>)

data class Medicines(
    @SerializedName("ReceteTarihi") val receteTarihi : String,
    @SerializedName("Barkod") val barkod : String,
    @SerializedName("ReceteNo") val receteNo : String,
    @SerializedName("IlacAdi") val ilacAdi : String,
    @SerializedName("Doz") val doz : String,
    @SerializedName("KullanimSekli") val kullanimSekli : String,
    @SerializedName("KullanımSayisi") val kullanimSayisi : String,
    @SerializedName("KullanımAdedi") val kullanimAdedi : String,
    @SerializedName("HastaneAdi") val hastaneAdi : String,
    @SerializedName("KlinikAdi") val klinikAdi : String,
    @SerializedName("a") val a : String,
    @SerializedName("b") val b : String
)

enum class LoginStatusType(val id: Int, val message: String){
    @SerializedName("0")
    SUCCESS(0, "Giris başarılı"),
    @SerializedName("1")
    ERROR(1, "Hatalı şifre girdiniz.")
}