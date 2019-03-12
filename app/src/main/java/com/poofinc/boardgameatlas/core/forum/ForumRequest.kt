package com.poofinc.boardgameatlas.core.forum

import com.android.volley.Response
import com.google.gson.reflect.TypeToken
import com.poofinc.boardgameatlas.core.net.APIRequest
import com.poofinc.boardgameatlas.data.forum.ForumResponse
import com.poofinc.boardgameatlas.data.game.Game
import com.poofinc.boardgameatlas.data.game.SearchResponse
import com.poofinc.boardgameatlas.data.search.Order
import java.lang.reflect.Type

class ForumRequest : APIRequest<ForumResponse>() {
    override var type: Type? = null
    override var apiPath: String = "forum"
    override var responseClass: Class<ForumResponse>? = ForumResponse::class.java
    private var news = false
    private var flair : String? = null


    fun news() : ForumRequest {
        news = true
        return this
    }

    fun flair(name: String) : ForumRequest {
        flair = name
        return this
    }

    override fun execute() {
        clearParameters()
        if (news) {
            addParameter("news", "true")
        }
        addParameter("limit", 100.toString())
        if (offset > 0) {
            addParameter("skip", offset.toString())
        }

        if (flair != null) {
            addParameter("flair", flair!!)
        }
        super.execute()
    }
}