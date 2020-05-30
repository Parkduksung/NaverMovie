package com.sample.rxnaversearchapi.network.di

import com.sample.rxnaversearchapi.network.api.MovieSearchApi
import com.sample.rxnaversearchapi.util.RetrofitInstance
import org.koin.dsl.module


private const val NAVER_URL = "https://openapi.naver.com/"

val networkModule = module {
    single<MovieSearchApi> { RetrofitInstance.getInstance(NAVER_URL) }
}