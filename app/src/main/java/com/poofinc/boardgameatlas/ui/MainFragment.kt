package com.poofinc.boardgameatlas.ui

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.android.volley.Response
import com.poofinc.boardgameatlas.R
import com.poofinc.boardgameatlas.core.game.SearchRequest
import com.poofinc.boardgameatlas.core.net.APIRequest
import com.poofinc.boardgameatlas.data.DataObject
import com.poofinc.boardgameatlas.data.DataType
import com.poofinc.boardgameatlas.data.Request
import com.poofinc.boardgameatlas.data.search.Order
import com.poofinc.boardgameatlas.ui.adapter.RecyclerAdapter
import android.util.DisplayMetrics
import kotlinx.android.synthetic.main.container_recycler_view.*
import kotlin.math.roundToInt
import com.poofinc.boardgameatlas.ui.adapter.ItemOffsetDecoration




abstract class MainFragment : Fragment() {
    abstract var requests: ArrayList<Request>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_main, container, false)

        initializeContent(v.findViewById(R.id.linearLayout), inflater)



        return v
    }

    private fun initializeContent(v: LinearLayout, inflater: LayoutInflater) {
        for (request in requests) {
            val container = inflater.inflate(R.layout.container_recycler_view, v, false)
            container.findViewById<TextView>(R.id.title).text = request.title
            val recyclerView =  container.findViewById<RecyclerView>(R.id.recyclerview)
            val layoutParams = recyclerView.layoutParams
            val progress = container.findViewById<ProgressBar>(R.id.progress)
            if (requests.size > 1) {
                layoutParams.height = DataType.getHeight(request.type)
                recyclerView.layoutParams = layoutParams
            } else {
                container.findViewById<TextView>(R.id.title).visibility = View.GONE
            }
            request.request.onSuccess(Response.Listener {
                progress.visibility = View.GONE
                var viewManager : RecyclerView.LayoutManager
                var scalingFactor = 1.0
                if (requests.size > 1) {
                    viewManager = LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
                } else {
                    var width = DataType.getWidth(request.type)
                    val displayMetrics = context?.getResources()?.displayMetrics
                    val screenWidth = displayMetrics!!.widthPixels
                    val noOfColumns = (screenWidth / width + 0.5).toInt()
                    var offset = width - (screenWidth / noOfColumns + 0.5)
                    viewManager = GridLayoutManager(recyclerView.context, noOfColumns)
                    val itemDecoration = ItemOffsetDecoration(recyclerView.context, (-offset/2).roundToInt())
                    recyclerView.addItemDecoration(itemDecoration)
                    recyclerView.setPadding(0,0,0,0)
                }
                if (it.getItems() != null) {
                    var viewAdapter = RecyclerAdapter(it.getItems()!!, this.activity as Activity, scalingFactor)
                    recyclerView.layoutManager = viewManager
                    recyclerView.adapter = viewAdapter
                }

            }).execute()

            v.addView(container)
        }
    }
}