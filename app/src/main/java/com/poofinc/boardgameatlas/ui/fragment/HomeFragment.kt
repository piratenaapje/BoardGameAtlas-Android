package com.poofinc.boardgameatlas.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Response
import com.poofinc.boardgameatlas.R
import com.poofinc.boardgameatlas.core.game.SearchRequest
import com.poofinc.boardgameatlas.core.net.APIRequest
import com.poofinc.boardgameatlas.core.video.VideoRequest
import com.poofinc.boardgameatlas.data.APIResponse
import com.poofinc.boardgameatlas.data.DataObject
import com.poofinc.boardgameatlas.data.DataType
import com.poofinc.boardgameatlas.data.Request
import com.poofinc.boardgameatlas.data.search.Order
import com.poofinc.boardgameatlas.ui.MainFragment
import com.poofinc.boardgameatlas.ui.adapter.RecyclerAdapter

class HomeFragment : MainFragment() {
    override var showSortMenuItem = false

    override var requests: ArrayList<Request>
        get() {
            var result = ArrayList<Request>()
            var request = Request()
            request.title = "Trending"
            request.type = DataType.GAME
            request.request = SearchRequest()
                    .maxRedditCount(200)
                    .minRedditWeekCount(1)
                    .minAverageUserRating(3.5f).order(Order.REDDIT_DAY_COUNT) as APIRequest<APIResponse>
            result.add(request)

            request = Request()
            request.title = "Most Popular"
            request.type = DataType.GAME
            request.request = SearchRequest().order(Order.POPULARITY) as APIRequest<APIResponse>
            result.add(request)


            request = Request()
            request.title = "Recent Videos"
            request.type = DataType.VIDEO
            request.request = VideoRequest() as APIRequest<APIResponse>
            result.add(request)


            request = Request()
            request.title = "Latest kickstarters"
            request.type = DataType.KICKSTARTER
            request.request = SearchRequest().kickstarter() as APIRequest<APIResponse>
            result.add(request)
            return result
        }
        set(value) {}

}