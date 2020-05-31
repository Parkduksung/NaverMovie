package com.sample.rxnaversearchapi.data.repository

import com.sample.rxnaversearchapi.network.model.MovieDataResponse

interface MovieRepository {
    fun getAllList(
        keyword: String,
        onSuccess: (movieDataResponse: MovieDataResponse) -> Unit,
        onFailure: () -> Unit
    )
}