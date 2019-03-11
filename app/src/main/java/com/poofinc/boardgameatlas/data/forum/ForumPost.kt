package com.poofinc.boardgameatlas.data.forum

import com.google.gson.annotations.SerializedName
import com.google.gson.internal.bind.DateTypeAdapter
import com.poofinc.boardgameatlas.data.DataObject
import com.poofinc.boardgameatlas.data.DataType
import com.poofinc.boardgameatlas.data.user.User
import java.util.*

class ForumPost : DataObject() {
    override var type: DataType = DataType.FORUMPOST
    var id: String? = null
    var title: String? = null
    var description: String? = null
    var url: String? = null
    @SerializedName("created_at")
    var created: Date? = null
    @SerializedName("image_url")
    var image: String? = null
    @SerializedName("num_likes")
    var likes: Int? = 0
    @SerializedName("num_comments")
    var comments: Int? = 0
    var user: User? = null
}