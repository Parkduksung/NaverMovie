package com.sample.rxnaversearchapi.data.repository

import com.sample.rxnaversearchapi.data.source.remote.MovieRemoteDataSource
import com.sample.rxnaversearchapi.network.model.MovieDataResponse
import com.sample.rxnaversearchapi.network.model.UserResponse

class MovieRepositoryImpl(private val movieRepository: MovieRemoteDataSource) : MovieRepository {
    override fun getAllList(
        keyword: String,
        onSuccess: (movieDataResponse: MovieDataResponse) -> Unit,
        onFailure: () -> Unit
    ) {
        movieRepository.getAllList(keyword, onSuccess, onFailure)
    }

    override fun getUser(
        userId: String,
        userPass: String,
        onSuccess: (userResponse: UserResponse) -> Unit,
        onFailure: () -> Unit
    ) {
        movieRepository.getUser(userId,userPass,onSuccess, onFailure)
    }
}