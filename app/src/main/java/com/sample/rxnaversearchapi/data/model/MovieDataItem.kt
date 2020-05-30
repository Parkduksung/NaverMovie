package com.sample.rxnaversearchapi.data.model

data class MovieDataItem(
    val display: Int,
    val movieResponseList: List<MovieItem>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)
