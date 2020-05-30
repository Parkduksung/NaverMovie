package com.sample.rxnaversearchapi.data.repository

import com.sample.rxnaversearchapi.network.model.MovieDataResponse

interface MovieRepository {
    fun getAllList(
        keyword: String,
        callback: (movieDataResponse: MovieDataResponse?) -> Unit
    )
}