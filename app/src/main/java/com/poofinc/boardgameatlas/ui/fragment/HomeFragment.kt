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
import com.poofinc.boardgameatlas.data.DataObject
import com.poofinc.boardgameatlas.data.search.Order
import com.poofinc.boardgameatlas.ui.adapter.RecyclerAdapter

class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.home_fragment, container, false)

        initializeContent(v)

        return v
    }

    private fun initializeContent(v: View) {
        getTrending(v)
    }

    private fun getTrending(v: View) {
        SearchRequest().order(Order.REDDIT_DAY_COUNT)
                .maxRedditCount(200)
                .minRedditWeekCount(1)
                .minAverageUserRating(3.5f)
                .onSuccess(Response.Listener {
                    val viewManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    val viewAdapter = RecyclerAdapter(it.games as ArrayList<DataObject>)

                    v.findViewById<RecyclerView>(R.id.recyclerview_trending).apply {
                        setHasFixedSize(true)
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }).execute()
    }
}