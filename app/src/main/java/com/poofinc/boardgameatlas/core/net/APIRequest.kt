package com.poofinc.boardgameatlas.core.net

import com.android.volley.Request
import com.android.volley.Response
import com.google.gson.reflect.TypeToken
import com.poofinc.boardgameatlas.core.API
import com.poofinc.boardgameatlas.data.game.Game
import java.lang.reflect.Type

abstract class APIRequest<T> {
    abstract var apiPath: String
    open var responseClass: Class<T>? = null
    open var type: Type? = null
    open var responseListener: Response.Listener<T> = Response.Listener {  }
    open var errorListener: Response.ErrorListener = Response.ErrorListener {  }

    open fun execute() {
        var url = API.location + apiPath + "&client_id=" + API.clientId

        var request = GsonRequest<T>(Request.Method.GET, url, responseClass, type,  responseListener, errorListener)

        NetworkQueue.getInstance().addToRequestQueue(request)
    }

    fun onError(listener: Response.ErrorListener) : APIRequest<T> {
        errorListener = listener
        return this
    }


    fun onSuccess(listener: Response.Listener<T>) : APIRequest<T> {
        responseListener = listener
        return this
    }
}