package com.poofinc.boardgameatlas.core.video

import com.android.volley.Response
import com.google.gson.reflect.TypeToken
import com.poofinc.boardgameatlas.core.net.APIRequest
import com.poofinc.boardgameatlas.data.game.Game
import com.poofinc.boardgameatlas.data.game.SearchResponse
import com.poofinc.boardgameatlas.data.search.Order
import com.poofinc.boardgameatlas.data.video.VideoResponse
import java.lang.reflect.Type

class VideoRequest : APIRequest<VideoResponse>() {
    override var type: Type? = null
    override var apiPath: String = "game/videos"
    override var responseClass: Class<VideoResponse>? = VideoResponse::class.java

    override fun execute() {
        addParameter("order_by", "published_date")
        addParameter("limit", "100")
        super.execute()
    }
}