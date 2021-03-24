package com.sample.rxnaversearchapi.data.source.remote

import android.util.Log
import com.sample.rxnaversearchapi.network.api.MovieSearchApi
import com.sample.rxnaversearchapi.network.api.UserApi
import com.sample.rxnaversearchapi.network.model.MovieDataResponse
import com.sample.rxnaversearchapi.network.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val movieSearchApi: MovieSearchApi,
    private val userApi: UserApi
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
                Log.d("결과", t.toString())
                onFailure()
            }
        })
    }

    override fun getUser(
        userId: String,
        userPass: String,
        onSuccess: (userResponse: UserResponse) -> Unit,
        onFailure: () -> Unit
    ) {
        userApi.getUser(userId, userPass).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                response.body()?.let { Log.d("결과", it.email.orEmpty()) }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("결과", t.toString())
            }
        })
    }
}