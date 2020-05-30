package com.sample.rxnaversearchapi.data.repository

import com.sample.rxnaversearchapi.data.source.remote.MovieRemoteDataSource
import com.sample.rxnaversearchapi.network.model.MovieDataResponse

class MovieRepositoryImpl(private val movieRepository: MovieRemoteDataSource) : MovieRepository {
    override fun getAllList(
        keyword: String,
        callback: (movieDataResponse: MovieDataResponse?) -> Unit
    ) {
        movieRepository.getAllList(keyword, callback)
    }
}