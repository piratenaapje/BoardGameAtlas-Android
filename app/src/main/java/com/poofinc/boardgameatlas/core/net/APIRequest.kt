package com.poofinc.boardgameatlas.core.net

import com.android.volley.Request
import com.android.volley.Response
import com.google.gson.reflect.TypeToken
import com.poofinc.boardgameatlas.core.API
import com.poofinc.boardgameatlas.core.game.SearchRequest
import com.poofinc.boardgameatlas.data.APIResponse
import com.poofinc.boardgameatlas.data.game.Game
import com.poofinc.boardgameatlas.data.search.Order
import java.lang.reflect.Type
import java.net.URLEncoder

abstract class APIRequest<T> {
    abstract var apiPath: String
    var parameters: String = ""
    open var responseClass: Class<T>? = null
    open var type: Type? = null
    open var responseListener: Response.Listener<T> = Response.Listener {  }
    open var errorListener: Response.ErrorListener = Response.ErrorListener {  }
    var order: Order? = null
    var reverse = false
    var offset = 0

    var firstParameter = true

    open fun execute() {
        addParameter("client_id", API.clientId)
        var url = API.location + apiPath + parameters

        var request = GsonRequest<T>(Request.Method.GET, url, responseClass, type,  responseListener, errorListener)

        NetworkQueue.getInstance().addToRequestQueue(request)
    }

    fun clearParameters() {
        firstParameter = true
        parameters = ""
    }

    fun onError(listener: Response.ErrorListener) : APIRequest<T> {
        errorListener = listener
        return this
    }


    fun onSuccess(listener: Response.Listener<T>) : APIRequest<T> {
        responseListener = listener
        return this
    }

    fun addParameter(key: String, value: String) : APIRequest<T> {
        if (firstParameter) {
            parameters += "?"
        } else {
            parameters += "&"
        }
        parameters += URLEncoder.encode(key) + "=" + URLEncoder.encode(value)
        firstParameter = false
        return this
    }


    fun order(value: Order) : APIRequest<T> {
        order = value
        return this
    }

    fun offset(value: Int) : APIRequest<T> {
        offset = value
        return this
    }
}