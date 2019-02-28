package com.poofinc.boardgameatlas.data.video

import com.poofinc.boardgameatlas.data.APIResponse
import com.poofinc.boardgameatlas.data.DataObject

class VideoResponse : APIResponse() {
    override fun getItems(): ArrayList<DataObject>? {
        return videos as ArrayList<DataObject>?
    }

    val videos : ArrayList<Video>? = null
}