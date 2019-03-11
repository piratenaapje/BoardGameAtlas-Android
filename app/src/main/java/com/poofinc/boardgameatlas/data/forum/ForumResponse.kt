package com.poofinc.boardgameatlas.data.forum

import com.poofinc.boardgameatlas.data.APIResponse
import com.poofinc.boardgameatlas.data.DataObject

class ForumResponse : APIResponse() {
    override fun getItems(): ArrayList<DataObject>? {
        return posts as ArrayList<DataObject>?
    }

    val posts : ArrayList<ForumPost>? = null
}