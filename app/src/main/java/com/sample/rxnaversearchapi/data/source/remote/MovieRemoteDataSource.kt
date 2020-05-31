package com.sample.rxnaversearchapi.data.source.remote

import com.sample.rxnaversearchapi.network.model.MovieDataResponse

interface MovieRemoteDataSource {
    fun getAllList(
        keyword: String,
        onSuccess: (movieDataResponse: MovieDataResponse) -> Unit,
        onFailure: () -> Unit
    )
}