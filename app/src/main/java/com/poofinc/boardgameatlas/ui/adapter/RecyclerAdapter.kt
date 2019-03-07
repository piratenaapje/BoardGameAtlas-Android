package com.poofinc.boardgameatlas.ui.adapter

import android.app.Activity
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
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



class RecyclerAdapter(var items: ArrayList<DataObject>, var activity: Activity, var scalingFactor: Double) : RecyclerView.Adapter<RecyclerViewHolder>() {
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

    fun addItems(add: ArrayList<DataObject>) {
        var oldSize = items.size
        items.addAll(add)
        notifyItemRangeInserted(oldSize, add.size)
    }

    override fun getItemCount(): Int {
        if (items == null) {
            return 0
        }
        return items!!.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerViewHolder, position: Int) {
        setClickListener(viewHolder, position)
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

                if (item.kickstarter_pledge != null && item.kickstarter_pledge!!.contains('.')) {
                    item.kickstarter_pledge = item.kickstarter_pledge!!.substring(0, item.kickstarter_pledge!!.indexOf('.'))
                }
                vh.goal.text = "$" + item.kickstarter_pledge + "/" + item.kickstarter_goal
                if (item.kickstarter_percent != null && item.kickstarter_percent!! >= 100) {
                    vh.goal.setTextColor(vh.itemView.resources.getColor(R.color.green))
                } else {
                    vh.goal.setTextColor(vh.itemView.resources.getColor(R.color.gray))
                }

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

    private fun setClickListener(viewHolder: RecyclerViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            when (items[position].type) {
                DataType.KICKSTARTER -> {
                    var item = items[position] as Game
                    var builder = CustomTabsIntent.Builder()
                    builder.setToolbarColor(activity.resources.getColor(R.color.colorPrimary));
                    var customTabsIntent = builder.build()
                    customTabsIntent.launchUrl(activity, Uri.parse(item.kickstarter_url));
                }
            }
        }
    }

}