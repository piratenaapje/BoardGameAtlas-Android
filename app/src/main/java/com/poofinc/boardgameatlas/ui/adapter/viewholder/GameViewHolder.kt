package com.poofinc.boardgameatlas.ui.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.poofinc.boardgameatlas.R


class GameViewHolder(v: View) : RecyclerViewHolder(v) {
    var imageView: ImageView
    var title: TextView
    var rating: RatingBar

    init {
        imageView = v.findViewById(R.id.image)
        title = v.findViewById(R.id.title)
        rating = v.findViewById(R.id.rating)
    }
}