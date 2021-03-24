package com.sample.rxnaversearchapi.di

import com.sample.rxnaversearchapi.network.api.MovieSearchApi
import com.sample.rxnaversearchapi.network.api.UserApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val NAVER_URL = "https://openapi.naver.com/"

private const val CLIENT_ID = "pqu5xvOzU1qikyXi94iM"
private const val SECRET_KEY = "i5W1ABuBft"

private val naverHeaderInterceptor = Interceptor {
    val original = it.request()
    val request = original.newBuilder()
        .header("X-Naver-Client-Id", CLIENT_ID)
        .header("X-Naver-Client-Secret", SECRET_KEY)
        .method(original.method(), original.body())
        .build()
    it.proceed(request)
}

val networkModule = module {
    single<MovieSearchApi> {
        get<Retrofit> { parametersOf(NAVER_URL, naverHeaderInterceptor) }
            .create(MovieSearchApi::class.java)
    }

    single<UserApi> {
        Retrofit.Builder()
            .baseUrl("http://3.35.154.27:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }


    factory<Retrofit> { (url: String, interceptor: Interceptor) ->
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(get())
            .client(get<OkHttpClient> { parametersOf(interceptor) })
            .build()
    }


    single<Converter.Factory> { GsonConverterFactory.create() }

    single<OkHttpClient> { (interceptor: Interceptor) ->
        OkHttpClient.Builder().addInterceptor(interceptor).build()
    }
}
