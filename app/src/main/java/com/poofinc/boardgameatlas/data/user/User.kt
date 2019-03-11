package com.poofinc.boardgameatlas.data.user

import com.google.gson.annotations.SerializedName
import com.poofinc.boardgameatlas.data.DataObject
import com.poofinc.boardgameatlas.data.DataType
import java.util.*

class User : DataObject() {
    override var type: DataType = DataType.USER
    var id: String? = null
    var username: String? = null
}