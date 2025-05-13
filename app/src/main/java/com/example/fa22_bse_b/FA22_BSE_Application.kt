package com.example.fa22_bse_b

import android.app.Application
import android.content.Context

class FA22_BSE_Application: Application() {

    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
    }

}