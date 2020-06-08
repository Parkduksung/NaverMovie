package com.sample.rxnaversearchapi.view.movie.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sample.rxnaversearchapi.R
import com.sample.rxnaversearchapi.databinding.FragmentMovieDetailsBinding
import com.sample.rxnaversearchapi.viewmodel.MovieDetailsViewModel
import org.koin.android.ext.android.get

class MovieDetailsFragment : Fragment() {

    private lateinit var viewModel: MovieDetailsViewModel
    private lateinit var binding: FragmentMovieDetailsBinding

    private val identifier by lazy {
        arguments?.getString(MOVIE_ITEM_IDENTIFIER)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false)
        binding.lifecycleOwner = this
        return binding.root
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