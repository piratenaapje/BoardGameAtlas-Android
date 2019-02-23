package com.poofinc.boardgameatlas.ui.util

import android.app.Application
import android.content.Context
import com.android.volley.VolleyLog
import com.android.volley.toolbox.Volley

class BGAApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this

        VolleyLog.DEBUG = true
    }

    companion object {
        lateinit var context: Context
    }
}