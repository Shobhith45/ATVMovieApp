package com.shobhith.atvmovieapp.util

import com.shobhith.atvmovieapp.R
import com.shobhith.atvmovieapp.domain.model.NavHeader

object Constant {
    const val API_KEY = "d138567cc556378574baf793c30fabe5"
    const val BASE_URL = "https://api.themoviedb.org/"
    const val THUMB_URL = "https://image.tmdb.org/t/p/w154"
    val movieCategories = listOf(
        NavHeader(0L , "Popular", R.drawable.ic_popular),
        NavHeader(1L , "Trending", R.drawable.ic_trending),
        NavHeader(2L , "Latest", R.drawable.ic_latest),
        NavHeader(3L , "Upcoming", R.drawable.ic_upcoming)
    )
}