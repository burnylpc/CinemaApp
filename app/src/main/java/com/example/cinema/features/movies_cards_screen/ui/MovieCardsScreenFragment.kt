package com.example.cinema.features.movies_cards_screen.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cinema.R
import com.example.cinema.databinding.MovieCardsFragmentBinding
import com.example.newsfeed.features.main_screen.ui.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieCardsScreenFragment: Fragment(R.layout.movie_cards_fragment) {

    private val adapterMovie by lazy { MovieCardsScreenAdapter(listOf()) }
    private val binding: MovieCardsFragmentBinding by viewBinding(MovieCardsFragmentBinding::bind)
    private val viewModel by viewModel<MovieCardsScreenViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        binding.recyclerView.apply {
            adapter = adapterMovie
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

    }

    private fun render(viewState: ViewState) {

        binding.progressBar.isVisible = viewState.isLoading
        adapterMovie.updateMovieCards(viewState.movies)

    }

}