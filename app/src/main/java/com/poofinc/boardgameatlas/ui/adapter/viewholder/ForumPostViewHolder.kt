package com.poofinc.boardgameatlas.ui.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.poofinc.boardgameatlas.R


class ForumPostViewHolder(v: View) : RecyclerViewHolder(v) {
    var image: ImageView
    var title: TextView
    var date: TextView
    var user: TextView
    var upvotes: TextView
    var comments: TextView

    init {
        image = v.findViewById(R.id.image)
        title = v.findViewById(R.id.title)
        date = v.findViewById(R.id.date)
        user = v.findViewById(R.id.user)
        upvotes = v.findViewById(R.id.upvotes)
        comments = v.findViewById(R.id.comments)
    }
}