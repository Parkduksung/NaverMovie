package com.sample.rxnaversearchapi.data.di

import com.sample.rxnaversearchapi.data.repository.MovieRepository
import com.sample.rxnaversearchapi.data.repository.MovieRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}