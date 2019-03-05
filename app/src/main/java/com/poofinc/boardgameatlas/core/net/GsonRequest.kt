package com.poofinc.boardgameatlas.core.net

import com.android.volley.NetworkResponse
import com.android.volley.ParseError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.HttpHeaderParser
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import java.io.UnsupportedEncodingException
import java.lang.reflect.Type
import java.nio.charset.Charset

/**
 * Make a GET request and return a parsed object from JSON.
 *
 * @param url URL of the request to make
 * @param clazz Relevant class object, for Gson's reflection
 * @param headers Map of request headers
 */
class GsonRequest<T>(
        method: Int,
        url: String,
        private val clazz: Class<T>?,
        private val type: Type?,
        private val listener: Response.Listener<T>,
        errorListener: Response.ErrorListener
) : Request<T>(method, url, errorListener) {
    private val gson = Gson()
    override fun getHeaders(): MutableMap<String, String> = super.getHeaders()

    override fun deliverResponse(response: T) = listener.onResponse(response)

    override fun parseNetworkResponse(response: NetworkResponse?): Response<T> {
        try {
            if (method == Request.Method.GET) {
                response?.headers?.put("cache-control", "no-transform, proxy-revalidate, max-age=7200, s-maxage=7200, public")
            }
            val json = String(
                    response?.data ?: ByteArray(0),
                    Charset.forName(HttpHeaderParser.parseCharset(response?.headers)))
            if (clazz != null) {
                return Response.success(
                        gson.fromJson(json, clazz!!),
                        HttpHeaderParser.parseCacheHeaders(response))
            } else if (type != null) {
                return Response.success(gson.fromJson(json, type),
                        HttpHeaderParser.parseCacheHeaders(response))
            }
        } catch (e: Exception) {
            return Response.error(ParseError(e))
        }
        return Response.error(null)
    }
}
