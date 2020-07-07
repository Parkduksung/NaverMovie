package com.sample.rxnaversearchapi.network.di

import com.sample.rxnaversearchapi.network.api.MovieSearchApi
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val NAVER_URL = "https://openapi.naver.com/"

val networkModule = module {

    single<MovieSearchApi> {
        get<Retrofit> { parametersOf(NAVER_URL) }
            .create(MovieSearchApi::class.java)
    }

    factory<Retrofit> { (url: String) ->
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(get())
            .build()
    }
    single<Converter.Factory> { GsonConverterFactory.create() }

}
