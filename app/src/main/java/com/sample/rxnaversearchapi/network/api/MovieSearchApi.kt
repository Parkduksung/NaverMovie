package com.sample.rxnaversearchapi.network.api

import com.sample.rxnaversearchapi.network.model.MovieDataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieSearchApi {
    @GET("v1/search/movie.json")
    fun getMovieList(
        @Query("query") keyWord: String
    ): Call<MovieDataResponse>


}