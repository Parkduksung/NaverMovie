package com.sample.rxnaversearchapi.presenter.movie

import android.os.Bundle
import android.view.View
import com.sample.rxnaversearchapi.R
import com.sample.rxnaversearchapi.base.BaseFragment
import com.sample.rxnaversearchapi.databinding.FragmentMovieDetailsBinding
import com.sample.rxnaversearchapi.viewmodel.MovieDetailsViewModel
import org.koin.android.ext.android.get

class MovieDetailsFragment :
    BaseFragment<FragmentMovieDetailsBinding>(R.layout.fragment_movie_details) {

    private lateinit var viewModel: MovieDetailsViewModel

    private val identifier by lazy {
        arguments?.getString(MOVIE_ITEM_IDENTIFIER)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            viewModel = get()
            vm = viewModel
            identifier?.let { identifier ->
                viewModel.request(identifier)
            }
        }
    }

    companion object {
        private const val MOVIE_ITEM_IDENTIFIER = "MOVIE_ITEM_IDENTIFIER"
        fun newInstance(movieItemUrl: String) =
            MovieDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(MOVIE_ITEM_IDENTIFIER, movieItemUrl)
                }
            }
    }

}