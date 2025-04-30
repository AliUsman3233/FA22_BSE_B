package com.example.fa22_bse_b.shared_helper

import android.content.Context

class SharedPreferenceHelper(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("FA22_BSE_B",Context.MODE_PRIVATE)


    fun saveData(value: String, key: String) {
        sharedPreferences.edit().putString(key,value).apply()
    }

    fun getData(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }
}