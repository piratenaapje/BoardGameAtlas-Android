package com.poofinc.boardgameatlas.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.poofinc.boardgameatlas.R
import com.poofinc.boardgameatlas.data.DataObject
import com.poofinc.boardgameatlas.data.DataType
import com.poofinc.boardgameatlas.data.game.Game
import com.poofinc.boardgameatlas.data.video.Video
import com.poofinc.boardgameatlas.ui.adapter.viewholder.GameViewHolder
import com.poofinc.boardgameatlas.ui.adapter.viewholder.KickstarterViewHolder
import com.poofinc.boardgameatlas.ui.adapter.viewholder.RecyclerViewHolder
import com.poofinc.boardgameatlas.ui.adapter.viewholder.VideoViewHolder



class RecyclerAdapter(var items: ArrayList<DataObject>) : RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerViewHolder {
        when (items[position].type) {
            DataType.GAME-> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.card_game, parent, false)
                return GameViewHolder(v)
            }
            DataType.KICKSTARTER-> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.card_kickstarter, parent, false)
                return KickstarterViewHolder(v)
            }
            DataType.VIDEO-> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.card_video, parent, false)
                return VideoViewHolder(v)
            }
            else -> return GameViewHolder(parent)
        }
    }

    override fun getItemCount(): Int {
        if (items == null) {
            return 0
        }
        return items!!.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerViewHolder, position: Int) {
        when (items[position].type) {
            DataType.GAME-> {
                var vh = viewHolder as GameViewHolder
                var item = items[position] as Game
                Glide.with(vh.imageView).load(item.imageUrl).into(vh.imageView)
                vh.title.text = item.name
                if (item.average_user_rating != null) {
                    vh.rating.rating = item.average_user_rating!!
                }
            }
            DataType.KICKSTARTER-> {
                var vh = viewHolder as KickstarterViewHolder
                var item = items[position] as Game
                Glide.with(vh.imageView).load(item.imageUrl).into(vh.imageView)
                vh.title.text = item.name
                vh.goal.text = "Goal: " + item.kickstarter_pledge + " of " + item.kickstarter_goal

                if (item.kickstarter_deadline != null) {
                    val diff = item.kickstarter_deadline!!.time - System.currentTimeMillis()
                    val seconds = diff / 1000
                    val minutes = seconds / 60
                    val hours = minutes / 60
                    val days = hours / 24

                    if (days > 0) {
                        vh.date.text = days.toString() + " days left"
                    }else if (hours > 0) {
                        vh.date.text = hours.toString() + " hours left"
                    }else if (minutes > 0) {
                        vh.date.text = minutes.toString() + " minutes left"
                    }else if (seconds > 0) {
                        vh.date.text = seconds.toString() + " seconds left"
                    }
                }

            }
            DataType.VIDEO-> {
                var vh = viewHolder as VideoViewHolder
                var item = items[position] as Video
                Glide.with(vh.imageView).load(item.image_url).into(vh.imageView)
                vh.title.text = item.title
                vh.channel.text = item.channel_name
            }
        }
    }

}