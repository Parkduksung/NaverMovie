package com.sample.rxnaversearchapi.view.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.rxnaversearchapi.R
import com.sample.rxnaversearchapi.databinding.ActivityMainBinding
import com.sample.rxnaversearchapi.view.movie.adapter.MovieAdapter
import com.sample.rxnaversearchapi.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieActivity : AppCompatActivity() {

    private val movieAdapter by lazy { MovieAdapter() }
    private val movieViewModel by viewModel<MovieViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.run {
            vm = movieViewModel
            lifecycleOwner = this@MovieActivity
            rvMovie.adapter = movieAdapter
        }
    }

}
