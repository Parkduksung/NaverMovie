package com.sample.rxnaversearchapi.di

import com.sample.rxnaversearchapi.data.source.remote.MovieRemoteDataSource
import com.sample.rxnaversearchapi.data.source.remote.MovieRemoteDataSourceImpl
import org.koin.dsl.module

val sourceModule = module {
    single<MovieRemoteDataSource> { MovieRemoteDataSourceImpl(get(),get()) }
}