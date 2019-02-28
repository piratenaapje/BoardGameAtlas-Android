package com.poofinc.boardgameatlas.data

abstract class APIResponse {
    abstract fun getItems() : ArrayList<DataObject>?
}