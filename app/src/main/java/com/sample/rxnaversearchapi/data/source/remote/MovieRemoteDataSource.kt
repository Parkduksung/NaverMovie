package com.sample.rxnaversearchapi.data.source.remote

import com.sample.rxnaversearchapi.network.model.MovieDataResponse
import com.sample.rxnaversearchapi.network.model.UserResponse

interface MovieRemoteDataSource {
    fun getAllList(
        keyword: String,
        onSuccess: (movieDataResponse: MovieDataResponse) -> Unit,
        onFailure: () -> Unit
    )

    fun getUser(
        userId: String,
        userPass: String,
        onSuccess: (userResponse: UserResponse) -> Unit,
        onFailure: () -> Unit
    )
}