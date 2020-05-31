package com.sample.rxnaversearchapi.data.repository

import com.sample.rxnaversearchapi.data.source.remote.MovieRemoteDataSource
import com.sample.rxnaversearchapi.network.model.MovieDataResponse

class MovieRepositoryImpl(private val movieRepository: MovieRemoteDataSource) : MovieRepository {
    override fun getAllList(
        keyword: String,
        onSuccess: (movieDataResponse: MovieDataResponse) -> Unit,
        onFailure: () -> Unit
    ) {
        movieRepository.getAllList(keyword, onSuccess, onFailure)
    }
}