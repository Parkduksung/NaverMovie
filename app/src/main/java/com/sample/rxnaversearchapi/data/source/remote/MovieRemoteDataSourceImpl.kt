package com.sample.rxnaversearchapi.data.source.remote

import com.sample.rxnaversearchapi.network.api.MovieSearchApi
import com.sample.rxnaversearchapi.network.model.MovieDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val movieSearchApi: MovieSearchApi
) : MovieRemoteDataSource {

    private val CLIENT_ID = "pqu5xvOzU1qikyXi94iM"
    private val SECRET_KEY = "i5W1ABuBft"

    override fun getAllList(
        keyword: String,
        callback: (movieDataResponse: MovieDataResponse?) -> Unit
    ) {
        movieSearchApi.getMovieList(CLIENT_ID, SECRET_KEY, keyword).enqueue(object :
            Callback<MovieDataResponse> {
            override fun onResponse(
                call: Call<MovieDataResponse>,
                response: Response<MovieDataResponse>
            ) {
                callback(response.body())
            }

            override fun onFailure(call: Call<MovieDataResponse>, t: Throwable) {
                callback(null)
            }
        })
    }
}