package com.sample.rxnaversearchapi.network.model


import com.google.gson.annotations.SerializedName
import com.sample.rxnaversearchapi.data.model.MovieDataItem

data class MovieDataResponse(
    @SerializedName("display")
    val display: Int,
    @SerializedName("items")
    val movieResponseList: List<MovieResponse>,
    @SerializedName("lastBuildDate")
    val lastBuildDate: String,
    @SerializedName("start")
    val start: Int,
    @SerializedName("total")
    val total: Int
) {
    fun toMovieDataItem(): MovieDataItem =
        MovieDataItem(
            display,
            movieResponseList.map { it.toMovieItem() },
            lastBuildDate,
            start,
            total
        )

}