package com.sample.rxnaversearchapi.view.movie.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.sample.rxnaversearchapi.R
import com.sample.rxnaversearchapi.databinding.ActivityMovieMainBinding
import com.sample.rxnaversearchapi.view.movie.details.MovieDetailsFragment
import com.sample.rxnaversearchapi.view.movie.main.adapter.MovieAdapter
import com.sample.rxnaversearchapi.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieActivity : AppCompatActivity() {

    private val movieAdapter by lazy { MovieAdapter() }
    private val movieViewModel by viewModel<MovieViewModel>()

    private lateinit var binding: ActivityMovieMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_main)
        binding.run {
            vm = movieViewModel
            lifecycleOwner = this@MovieActivity
            rvMovie.adapter = movieAdapter
        }

        movieViewModel.run {
            clickMovieIdentifier.observe(this@MovieActivity, Observer { movieItem ->
                showFragment(MovieDetailsFragment.newInstance(movieItem.link))
            })
        }
    }

    private fun showFragment(fragment: Fragment) {
        binding.fragmentContainerView.bringToFront()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .addToBackStack(null)
            .commit()
    }


}
