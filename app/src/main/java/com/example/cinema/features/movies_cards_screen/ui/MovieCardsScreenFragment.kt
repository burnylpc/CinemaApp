package com.example.cinema.features.movies_cards_screen.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cinema.R
import com.example.cinema.databinding.MovieCardsFragmentBinding
import com.example.newsfeed.features.main_screen.ui.SingleEvent
import com.example.newsfeed.features.main_screen.ui.UIEvent
import com.example.newsfeed.features.main_screen.ui.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieCardsScreenFragment : Fragment(R.layout.movie_cards_fragment) {

    private val binding: MovieCardsFragmentBinding by viewBinding(MovieCardsFragmentBinding::bind)
    private val viewModel by viewModel<MovieCardsScreenViewModel>()
    private val adapterMovie by lazy {
        MovieCardsScreenAdapter(listOf(),
            {
                viewModel.processUiEvent(UIEvent.OnButtonAboutClick(it))
            },
            {
                viewModel.processUiEvent(UIEvent.OnButtonWatchClick(it))
            })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        viewModel.singleLiveEvent.observe(viewLifecycleOwner, ::onSingleEvent)

        binding.recyclerView.apply {
            adapter = adapterMovie
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

    }

    private fun render(viewState: ViewState) {

        binding.progressBar.isVisible = viewState.isLoading
        adapterMovie.updateMovieCards(viewState.movies)

    }

    private fun onSingleEvent(event: SingleEvent) {
        when (event) {
            is SingleEvent.OpenAboutMovieCard -> {
                Log.d("", "CLICKED OpenAboutMovieCard")
                parentFragmentManager.beginTransaction()
                    .replace(android.R.id.content, MovieAboutFragment.newInstance(event.movie))
                    .addToBackStack("movies")
                    .commit()
            }

            is SingleEvent.OpenWatchMovieCard -> {
                Log.d("", "CLICKED OpenWatchMovieCard")
                parentFragmentManager.beginTransaction()
                    .replace(android.R.id.content, MoviePlayerFragment.newInstance(event.movie))
                    .addToBackStack("movies")
                    .commit()
            }
        }
    }

}