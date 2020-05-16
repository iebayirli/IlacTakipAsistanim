package com.example.ilactakipasistanim.common

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import java.util.*

class SharedPrefHelper(activity: Activity) {

    private var sharedPreferences: SharedPreferences

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


    fun getBoolean(key: SharedPrefKey): Boolean {
        return sharedPreferences.getBoolean(key.toString(), false)
    }

    fun getString(key: SharedPrefKey): String {
        return sharedPreferences.getString(key.toString(), "") ?: ""
    }

}
enum class SharedPrefKey{
    IS_ON_BOARDING_SHOWED;

    override fun toString(): String {
        return this.name.toLowerCase();
    }
}
