package com.poofinc.boardgameatlas.core.game

import com.android.volley.Response
import com.google.gson.reflect.TypeToken
import com.poofinc.boardgameatlas.core.net.APIRequest
import com.poofinc.boardgameatlas.data.game.Game
import com.poofinc.boardgameatlas.data.game.SearchResponse
import java.lang.reflect.Type

class SearchRequest : APIRequest<SearchResponse>() {
    override var type: Type? = null
    override var apiPath: String = "search"
    override var responseClass: Class<SearchResponse>? = SearchResponse::class.java



    override fun execute() {
        apiPath += "?name=Catan"
        super.execute()
    }
}