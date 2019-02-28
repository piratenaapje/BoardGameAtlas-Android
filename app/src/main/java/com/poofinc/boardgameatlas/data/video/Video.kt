package com.poofinc.boardgameatlas.data.video

import com.poofinc.boardgameatlas.data.DataObject
import com.poofinc.boardgameatlas.data.DataType

class Video : DataObject() {
    override var type: DataType = DataType.VIDEO

    var url: String? = null
    var title: String? = null
    var channel_name: String? = null
    var thumb_url: String? = null
    var image_url: String? = null
}