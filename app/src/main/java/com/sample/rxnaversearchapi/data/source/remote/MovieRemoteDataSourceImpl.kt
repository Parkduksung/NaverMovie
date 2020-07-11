package com.sample.rxnaversearchapi.data.source.remote

import com.sample.rxnaversearchapi.network.api.MovieSearchApi
import com.sample.rxnaversearchapi.network.model.MovieDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val movieSearchApi: MovieSearchApi
) : MovieRemoteDataSource {

    override fun getAllList(
        keyword: String,
        onSuccess: (movieDataResponse: MovieDataResponse) -> Unit,
        onFailure: () -> Unit
    ) {
        movieSearchApi.getMovieList(keyword).enqueue(object :
            Callback<MovieDataResponse> {
            override fun onResponse(
                call: Call<MovieDataResponse>,
                response: Response<MovieDataResponse>
            ) {
                response.body()?.let { onSuccess(it) }
            }

            override fun onFailure(call: Call<MovieDataResponse>, t: Throwable) {
                onFailure()
            }
        })
    }

}