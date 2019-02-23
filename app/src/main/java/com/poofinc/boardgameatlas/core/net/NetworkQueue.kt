package com.poofinc.boardgameatlas.core.net

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.poofinc.boardgameatlas.ui.util.BGAApplication

class NetworkQueue constructor(context: Context) {
    companion object {
        @Volatile
        private var INSTANCE: NetworkQueue? = null
        fun getInstance() =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: NetworkQueue(BGAApplication.context).also {
                        INSTANCE = it
                    }
                }
    }
    val requestQueue: RequestQueue by lazy {
        // applicationContext is key, it keeps you from leaking the
        // Activity or BroadcastReceiver if someone passes one in.
        Volley.newRequestQueue(context.applicationContext)
    }
    fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue.add(req)
    }
}
