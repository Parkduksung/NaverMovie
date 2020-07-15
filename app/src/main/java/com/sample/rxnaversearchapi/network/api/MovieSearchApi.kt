package com.sample.rxnaversearchapi.network.api

import com.sample.rxnaversearchapi.network.model.MovieDataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface MovieSearchApi {
    @GET("v1/search/movie.json")
    fun getMovieList(
        @Query("query") keyWord: String,
        @Query("display") display: Int = INIT_DISPLAY,
        @Query("yearfrom") searchRangeYearStart: Int = START_YEAR,
        @Query("yearto") searchRangeYearEnd: Int = END_YEAR
    ): Call<MovieDataResponse>

    companion object {
        private const val INIT_DISPLAY = 100
        private const val START_YEAR = 2000
        private var END_YEAR = Calendar.getInstance().get(Calendar.YEAR)
    }
}