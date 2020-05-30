package com.sample.rxnaversearchapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.rxnaversearchapi.data.model.MovieItem
import com.sample.rxnaversearchapi.data.repository.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val keyWord = MutableLiveData<String>()

    private val _movieList =
        MutableLiveData<List<MovieItem>>()
    val movieList: LiveData<List<MovieItem>>
        get() = _movieList

    fun searchByKeyWord(keyWord: String?) {
        keyWord?.let {
            movieRepository.getAllList(keyWord, callback = { movieDataResponse ->
                movieDataResponse?.let {
                    val toMovieItemList =
                        movieDataResponse.toMovieDataItem().movieResponseList
                    _movieList.value = toMovieItemList
                }
            })
        }
    }
}