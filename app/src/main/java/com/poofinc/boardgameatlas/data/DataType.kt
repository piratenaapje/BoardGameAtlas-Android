package com.poofinc.boardgameatlas.data

import com.poofinc.boardgameatlas.R
import com.poofinc.boardgameatlas.ui.util.BGAApplication

enum class DataType {
    GAME, REVIEW, VIDEO, KICKSTARTER;

    companion object {
        fun getHeight(type: DataType): Int {
            when (type) {
                GAME -> return BGAApplication.context.resources.getDimensionPixelSize(R.dimen.card_game_height)
                KICKSTARTER -> return BGAApplication.context.resources.getDimensionPixelSize(R.dimen.card_game_height)
                VIDEO -> return BGAApplication.context.resources.getDimensionPixelSize(R.dimen.card_video_height)
            }
            return 0
        }
    }
}