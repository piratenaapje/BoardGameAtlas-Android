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
import com.poofinc.boardgameatlas.ui.adapter.viewholder.GameViewHolder
import com.poofinc.boardgameatlas.ui.adapter.viewholder.RecyclerViewHolder

class RecyclerAdapter(var items: ArrayList<DataObject>) : RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerViewHolder {
        when (items[position].type) {
            DataType.GAME-> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.card_game, parent, false)
                return GameViewHolder(v)
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
            }
        }
    }

}