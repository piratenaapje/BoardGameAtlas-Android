package com.poofinc.boardgameatlas.data.search

enum class Order(val value: String) {
    POPULARITY("popularity"),
    PRICE("price"),
    DISCOUNT("discount"),
    REDDIT_WEEK_COUNT("reddit_week_count"),
    REDDIT_DAY_COUNT("reddit_day_count"),
    NAME("name"),
    PUBLISHER_YEAR("year_publisher"),
    MIN_AGE("min_age"),
    MIN_PLAYTIME("min_playtime"),
    MAX_PLAYTIME("max_playtime"),
    MIN_PLAYERS("min_players"),
    MAX_PLAYERS("max_players"),
    DEADLINE("deadline")
}