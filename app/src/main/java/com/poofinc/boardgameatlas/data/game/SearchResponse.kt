package com.poofinc.boardgameatlas.data.game

import com.poofinc.boardgameatlas.data.APIResponse
import com.poofinc.boardgameatlas.data.DataObject

class SearchResponse : APIResponse() {
    override fun getItems(): ArrayList<DataObject>? {
        return games as ArrayList<DataObject>?
    }

    val games : ArrayList<Game>? = null
}