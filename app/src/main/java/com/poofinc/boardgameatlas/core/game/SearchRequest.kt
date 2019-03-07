package com.poofinc.boardgameatlas.core.game

import com.android.volley.Response
import com.google.gson.reflect.TypeToken
import com.poofinc.boardgameatlas.core.net.APIRequest
import com.poofinc.boardgameatlas.data.game.Game
import com.poofinc.boardgameatlas.data.game.SearchResponse
import com.poofinc.boardgameatlas.data.search.Order
import java.lang.reflect.Type

class SearchRequest : APIRequest<SearchResponse>() {
    override var type: Type? = null
    override var apiPath: String = "search"
    override var responseClass: Class<SearchResponse>? = SearchResponse::class.java

    private var minRedditWeekCount: Int? = null
    private var maxRedditCount: Int? = null
    private var minAverageUserRating: Float? = null
    private var kickstarter = false
    private var ascending = false


    fun minRedditWeekCount(value: Int) : SearchRequest {
        minRedditWeekCount = value
        return this
    }

    fun maxRedditCount(value: Int) : SearchRequest {
        maxRedditCount = value
        return this
    }

    fun minAverageUserRating(value: Float) : SearchRequest {
        minAverageUserRating = value
        return this
    }

    fun kickstarter() : SearchRequest {
        kickstarter = true
        return this
    }

    fun ascending() : SearchRequest {
        ascending = true
        return this
    }

    override fun execute() {
        clearParameters()
        if (order != null) {
            addParameter("order_by", order!!.value)
        }
        if (minRedditWeekCount != null) {
            addParameter("gt_reddit_week_count", minRedditWeekCount.toString())
        }
        if (maxRedditCount != null) {
            addParameter("lt_reddit_count", maxRedditCount.toString())
        }
        if (minAverageUserRating != null) {
            addParameter("gt_average_user_rating", minAverageUserRating.toString())
        }
        if (kickstarter) {
            addParameter("kickstarter", "true")
        }
        if (reverse) {
            addParameter("ascending", (!ascending).toString())
        } else {
            addParameter("ascending", (ascending).toString())
        }
        addParameter("limit", 100.toString())
        if (offset > 0) {
            addParameter("skip", offset.toString())
        }
        super.execute()
    }
}