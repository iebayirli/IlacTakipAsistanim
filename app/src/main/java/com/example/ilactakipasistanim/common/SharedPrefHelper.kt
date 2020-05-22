package com.example.ilactakipasistanim.common

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList

class SharedPrefHelper(activity: Activity) {

    private var sharedPreferences: SharedPreferences
    private var gson = Gson()

    val PREF_NAME = "IlacTakipAsist_Prefs"
    init {
        sharedPreferences = activity.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    }

    fun saveBoolean(key: SharedPrefKey, value: Boolean){
        val edit = sharedPreferences.edit()
        edit.putBoolean(key.toString(), value)
        edit.apply()
    }

    fun saveString(key: SharedPrefKey, value: String) {
        val edit = sharedPreferences.edit()
        edit.putString(key.toString(), value)
        edit.apply()
    }
    fun saveManuelMedicines(key : SharedPrefKey, value: ArrayList<MedicinesClass>){
        val edit =sharedPreferences.edit()
        var json = gson.toJson(value)
        edit.putString(key.toString(),json)
        edit.apply()
    }
    fun getIDList(key : SharedPrefKey) : ArrayList<String>{
        var json = sharedPreferences.getString(key.toString(),"")
        var type = object : TypeToken<ArrayList<String>>() {}.type
        var myList :ArrayList<String> = gson.fromJson(json,type)

        return myList
    }
    fun saveIDList(key : SharedPrefKey , items : ArrayList<String>){
        val edit =sharedPreferences.edit()
        var json = gson.toJson(items)
        edit.putString(key.toString(),json)
        edit.apply()
    }
    fun getManuelMedicines(key : SharedPrefKey) : ArrayList<MedicinesClass>{
        var json = sharedPreferences.getString(key.toString(),"")
        var type = object : TypeToken<List<MedicinesClass>>() {}.type
        var myList :ArrayList<MedicinesClass> = gson.fromJson(json,type)

        return myList
    }
    fun saveAlarmMedicine(key : SharedPrefKey , item : MedicinesClass){
        val edit = sharedPreferences.edit()
        var json = gson.toJson(item)
        edit.putString(key.toString(),json)
        edit.apply()
    }
    fun getAlarmMedicine (key : SharedPrefKey) : MedicinesClass{
        var json = sharedPreferences.getString(key.toString(),"")
        var item = gson.fromJson( json, MedicinesClass::class.java)
        return item
    }
    fun getBoolean(key: SharedPrefKey): Boolean {
        return sharedPreferences.getBoolean(key.toString(), false)
    }

    fun getString(key: SharedPrefKey): String {
        return sharedPreferences.getString(key.toString(), "") ?: ""
    }

}
enum class SharedPrefKey{
    IS_ON_BOARDING_SHOWED,
    IS_FIRST_INIT_DONE,
    NAME,
    SURNAME,
    AGE,
    ENDEKS,
    MANUEL_ADD_MEDICINES,
    ILK_ILAC,
    UNIQUE_ID_LIST,
    ALARM_MEDICINE;

    override fun toString(): String {
        return this.name.toLowerCase();
    }
}
data class MedicinesClass(var ilacAdi : String,
                          var kullanimSekli : String,
                          var baslangicTarihi : String,
                          var kullanimSayisi : String,
                          var hastaneAdi : String = " ",
                          var isFromEnabiz : Boolean = false)