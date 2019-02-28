package com.poofinc.boardgameatlas.ui.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.poofinc.boardgameatlas.R


class VideoViewHolder(v: View) : RecyclerViewHolder(v) {
    var imageView: ImageView
    var title: TextView
    var channel: TextView

    init {
        imageView = v.findViewById(R.id.image)
        title = v.findViewById(R.id.title)
        channel = v.findViewById(R.id.channel)
    }
}