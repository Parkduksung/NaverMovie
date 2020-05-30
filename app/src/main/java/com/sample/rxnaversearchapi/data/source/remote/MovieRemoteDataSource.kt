package com.sample.rxnaversearchapi.data.source.remote

import com.sample.rxnaversearchapi.network.model.MovieDataResponse

interface MovieRemoteDataSource {

    fun getAllList(
        keyword: String,
        callback: (movieDataResponse: MovieDataResponse?) -> Unit
    )
}