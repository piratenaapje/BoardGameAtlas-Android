package com.poofinc.boardgameatlas.data.search

enum class Order(val value: String, val displayName: String) {
    POPULARITY("popularity", "Popularity"),
    PRICE("price", "Price"),
    DISCOUNT("discount", "Discount"),
    REDDIT_WEEK_COUNT("reddit_week_count", "Hot games"),
    REDDIT_DAY_COUNT("reddit_day_count", "Reddit day count"),
    NAME("name", "Name"),
    PUBLISHER_YEAR("year_published", "Published year"),
    MIN_AGE("min_age", "Minimum age"),
    MIN_PLAYTIME("min_playtime", "Minimum playtime"),
    MAX_PLAYTIME("max_playtime", "Maximum playtime"),
    MIN_PLAYERS("min_players", "Minimum players"),
    MAX_PLAYERS("max_players", "Maximum players"),
    DEADLINE("deadline", "Deadline"),
    RECENT("popularity", "Recent"),
    CREATED("published_date", "Recent"),
    VIEW_COUNT("view_count", "Views")
}