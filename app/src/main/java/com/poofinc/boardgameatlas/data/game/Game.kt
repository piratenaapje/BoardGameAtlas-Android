package com.poofinc.boardgameatlas.data.game

import com.google.gson.annotations.SerializedName
import com.google.gson.internal.bind.DateTypeAdapter
import com.poofinc.boardgameatlas.data.DataObject
import com.poofinc.boardgameatlas.data.DataType
import java.util.*

class Game : DataObject() {
    override var type: DataType = DataType.GAME
    get() {
        return when (kickstarter_url) {
            null -> DataType.GAME
            else -> DataType.KICKSTARTER
        }
    }
    var id: String? = null
    var name: String? = null
    var names: ArrayList<String>? = null
    @SerializedName("year_published")
    var yearPublished: Int? = null
    @SerializedName("min_players")
    var minPlayers: Int? = null
    @SerializedName("max_players")
    var maxPlayers: Int? = null
    @SerializedName("min_playtime")
    var minPlaytime: Int? = null
    @SerializedName("max_playtime")
    var maxPlaytime: Int? = null
    @SerializedName("min_age")
    var minAge: Int? = null
    var description: String? = null
    @SerializedName("description_preview")
    var descriptionPreview: String? = null
    @SerializedName("thumb_url")
    var thumbUrl: String? = null
    @SerializedName("image_url")
    var imageUrl: String? = null
    var url: String? = null
    var price: Float? = null
    var msrp: Float? = null
    var discount: Float? = null
    @SerializedName("primary_publisher")
    var primaryPublisher: String? = null
    var publishers: ArrayList<String>? = null
    var designers: ArrayList<String>? = null
    var developers: ArrayList<String>? = null
    var artists: ArrayList<String>? = null
    var average_user_rating: Float? = null
    var kickstarter_url:String? = null
    var kickstarter_pledge: String? = null
    var kickstarter_goal: String? = null
    var kickstarter_deadline: Date? = null
}